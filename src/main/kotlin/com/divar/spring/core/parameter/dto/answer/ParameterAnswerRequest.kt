package com.divar.spring.core.parameter.dto.answer

import com.divar.spring.core.ads.entity.Ads
import com.divar.spring.core.parameter.entity.Parameter
import com.divar.spring.core.parameter.entity.ParameterAnswer

data class ParameterAnswerRequest(
    val answer: String,
    val parameterId: Long,
)

fun ParameterAnswerRequest.toEntity(ads: Ads, parameter: Parameter): ParameterAnswer {
    return ParameterAnswer(
        answer = answer,
        ads = ads,
        parameter = parameter
    )
}