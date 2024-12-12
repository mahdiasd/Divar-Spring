package com.divar.spring.core.ads.service

import com.divar.spring.core.ads.dto.AdsRequest
import com.divar.spring.core.ads.dto.CategoriesOfAds
import com.divar.spring.core.ads.dto.toEntity
import com.divar.spring.core.ads.dto.toResponse
import com.divar.spring.core.ads.entity.Ads
import com.divar.spring.core.ads.repository.AdsRepository
import com.divar.spring.core.category.service.CategoryService
import com.divar.spring.core.image.service.ImageService
import com.divar.spring.core.location.service.NeighborhoodService
import com.divar.spring.core.parameter.dto.answer.ParameterAnswerRequest
import com.divar.spring.core.parameter.dto.answer.toEntity
import com.divar.spring.core.parameter.service.ParameterAnswerService
import com.divar.spring.core.parameter.service.ParameterService
import com.divar.spring.core.user.UserService
import com.divar.spring.utils.response.ApiResponse
import com.divar.spring.utils.response.BadRequestError
import com.divar.spring.utils.response.UnauthorizedError
import com.divar.spring.utils.security.JwtService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import kotlin.jvm.optionals.getOrNull

@Service
class AdsService(
    val repository: AdsRepository,
    val jwtService: JwtService,
    val userService: UserService,
    val neighborhoodService: NeighborhoodService,
    val categoryService: CategoryService,
    val parameterAnswerService: ParameterAnswerService,
    val parameterService: ParameterService,
    val imageService: ImageService,
) {


    fun save(value: Ads): Ads {
        return repository.save(value)
    }

    fun save(adsRequest: AdsRequest, token: String, images: List<MultipartFile>?): ResponseEntity<*> {
        val user =
            userService.findByMobile(jwtService.extractMobile(token)) ?: return ApiResponse.error(
                UnauthorizedError(
                    message = "توکن صحیح نمی باشد!"
                )
            )

        val neighborhood = neighborhoodService.getReferenceById(adsRequest.neighborhoodId)
            ?: return ApiResponse.error(BadRequestError(message = "محله یافت نشد!"))

        val category = categoryService.getReferenceById(adsRequest.categoryId)
            ?: return ApiResponse.error(BadRequestError(message = "دسته بندی یافت نشد!"))

        val ads = repository.save(adsRequest.toEntity(neighborhood, category, user))

        val answers = adsRequest.answers.map {
            it.toEntity(
                ads = ads,
                parameter = parameterService.getReferenceById(it.parameterId) ?: return ApiResponse.error(
                    BadRequestError(message = "پارامتر یافت نشد!")
                )
            )
        }

        images?.let {
            imageService.saveAll(files = it, ads = ads)
        }
        parameterAnswerService.saveAll(answers)

        return ApiResponse.success(ads.toResponse())
    }

    fun saveAll(values: List<Ads>) {
        repository.saveAll(values)
    }

    fun findById(id: Long): Ads? {
        return repository.findById(id).getOrNull()
    }

    fun findAll(page: Int, pageSize: Int = 20): Page<Ads> {
        val pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "id"))
        return repository.findAll(pageable)
    }

    fun findAll(categoryId: Long, page: Int, pageSize: Int = 20): Page<Ads> {
        val pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "id"))
        return repository.findAllByCategoryId(categoryId, pageable)
    }


    fun findCategoriesWithAdsCount(searchText: String, cityId: Long): List<CategoriesOfAds> {
        return repository.findCategoriesWithAdsCount(searchText, cityId = cityId).map {
            CategoriesOfAds(
                categoryName = it[0] as String,
                categoryId = it[1] as Long,
                adsCount = it[2] as Long,
                adsTitle = it[3] as String
            )
        }
    }

    fun findAdsByFilter(
        title: String?,
        cityId: Long?,
        categoryId: Long?,
        neighborhoodId: Long?,
        page: Int,
        parameterAnswerRequests: List<ParameterAnswerRequest>?,
        price: String?,
        pageSize: Int = 20,
    ): Page<Ads> {
        val pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "createAt"))

        // 10000 - 250000
        val minPrice = price?.split(" - ")?.firstOrNull()
        val maxPrice = price?.split(" - ")?.lastOrNull()

        return repository.findAdsByFilter(
            title = title,
            cityId = cityId,
            categoryId = categoryId,
            minPrice = if (minPrice.isNullOrEmpty()) null else minPrice.toDouble(),
            maxPrice = if (maxPrice.isNullOrEmpty()) null else maxPrice.toDouble(),
            parametersIds = parameterAnswerRequests?.map { it.parameterId },
            answers = parameterAnswerRequests?.map { it.answer },
            neighborhoodId = neighborhoodId,
            pageable = pageable
        )
    }
}
