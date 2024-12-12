package com.divar.spring.core.parameter.dto.answer

import com.divar.spring.core.parameter.dto.ParameterResponse
import com.divar.spring.core.parameter.dto.toResponse
import com.divar.spring.core.parameter.entity.ParameterAnswer

data class ParameterAnswerResponse(
    val answer: String,
    val parameter: ParameterResponse,
)

fun ParameterAnswer.toResponse(): ParameterAnswerResponse {
    return ParameterAnswerResponse(
        answer = answer,
        parameter = parameter.toResponse(false)
    )
}
