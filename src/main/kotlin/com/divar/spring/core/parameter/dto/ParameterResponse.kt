package com.divar.spring.core.parameter.dto

import com.divar.spring.core.category.dto.CategoryResponse
import com.divar.spring.core.category.dto.toResponse
import com.divar.spring.core.parameter.entity.DataType
import com.divar.spring.core.parameter.entity.Parameter
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ParameterResponse(
    val id: Long = 0,

    val name: String,

    val dataType: DataType,

    val acceptedOptions: List<String>? = null,

    val category: CategoryResponse?,
)

fun Parameter.toResponse(includeCategories: Boolean = true): ParameterResponse {
    return ParameterResponse(
        id = id,
        name = name,
        dataType = dataType,
        acceptedOptions = acceptedOptions?.split(", ")?.map { it.trim() },
        category = if (includeCategories) category.toResponse() else null
    )
}