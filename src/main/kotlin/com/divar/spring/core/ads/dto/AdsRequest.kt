package com.divar.spring.core.ads.dto

import com.divar.spring.core.ads.entity.Ads
import com.divar.spring.core.category.entity.Category
import com.divar.spring.core.location.entity.Neighborhood
import com.divar.spring.core.parameter.dto.answer.ParameterAnswerRequest
import com.divar.spring.core.parameter.entity.ParameterAnswer
import com.divar.spring.core.user.entity.User

data class AdsRequest(
    val id: Long? = 0,

    val title: String,

    val description: String,

    val price: String,

    val neighborhoodId: Long,

    val categoryId: Long,

    val answers: List<ParameterAnswerRequest>
)

fun AdsRequest.toEntity(neighborhood: Neighborhood, category: Category, user: User): Ads {
    return Ads(
        id = id ?: 0,
        title = title,
        description = description,
        price = price,
        neighborhood = neighborhood,
        category = category,
        user = user,
    )
}