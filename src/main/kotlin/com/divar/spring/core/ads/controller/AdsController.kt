package com.divar.spring.core.ads.controller

import com.divar.spring.core.ads.dto.AdsRequest
import com.divar.spring.core.ads.dto.GetAdsRequest
import com.divar.spring.core.ads.dto.toResponse
import com.divar.spring.core.ads.dto.toSummaryResponse
import com.divar.spring.core.ads.service.AdsService
import com.divar.spring.utils.response.*
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("api/v1/")
class AdsController(
    val service: AdsService,
    private val jacksonObjectMapper: ObjectMapper
) {

    @PostMapping("ads")
    fun createAds(
        @RequestPart("images") images: List<MultipartFile>? = null,
        @RequestPart("ads") adsRequestString: String? = null,
        @RequestHeader("Authorization") token: String? = null,
    ): ResponseEntity<*> {
        if (token.isNullOrEmpty()) return ApiResponse.error(UnauthorizedError())
        if (adsRequestString.isNullOrEmpty()) return ApiResponse.error(BadRequestError(message = "اطلاعات آگهی ارسال نشده است!"))
        val adsRequest = jacksonObjectMapper.readValue(adsRequestString, AdsRequest::class.java)
            ?: return ApiResponse.error(BadRequestError(message = "اطلاعات آگهی صحیح نمی باشد!"))

        return service.save(adsRequest, token, images)

    }

    @PostMapping("ads/filter")
    fun getAds(
        @RequestBody getAdsRequest: GetAdsRequest,
    ): ResponseEntity<*> {
        val adsPage = service.findAdsByFilter(
            title = getAdsRequest.searchText,
            categoryId = getAdsRequest.categoryId,
            cityId = getAdsRequest.cityId,
            parameterAnswerRequests = getAdsRequest.parameters,
            price = getAdsRequest.price,
            neighborhoodId = getAdsRequest.neighborhoodId,
            page = getAdsRequest.page
        )
        return ApiResponse.success(
            adsPage.toMyPage(content = adsPage.content.map { it.toSummaryResponse() })
        )
    }

    @GetMapping("ads/detail")
    fun getAdsDetail(
        @RequestParam("id") adsId: Long? = null
    ): ResponseEntity<*> {
        if (adsId == null) return ApiResponse.error(BadRequestError(message = "ای دی آگهی ضروری است!"))
        service.findById(adsId)?.let {
            return ApiResponse.success(it.toResponse())
        } ?: return ApiResponse.error(GoneError())
    }

    @GetMapping("ads/categories_of_ads")
    fun getCategoriesOfAds(
        @RequestParam("searchText") searchText: String? = null,
        @RequestParam("cityId") cityId: Long? = null,
    ): ResponseEntity<*> {
        if (searchText.isNullOrEmpty()) return ApiResponse.error(BadRequestError(message = "متن جستج الزامی است!"))
        if (cityId == null) return ApiResponse.error(BadRequestError(message = "برای جستجو، ارسال شهر الزامی است!"))
        service.findCategoriesWithAdsCount(searchText, cityId).let {
            return ApiResponse.success(it)
        }
    }

}