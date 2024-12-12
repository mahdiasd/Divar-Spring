package com.divar.spring.core.location.dto

import com.divar.spring.core.location.entity.Province

data class ProvinceResponse(
    val id: Long,
    val name: String,
    val cities: List<CityResponse>? = null
)

fun Province.toResponse(includeCities: Boolean = true, includeNeighborhoods: Boolean = true): ProvinceResponse {
    return ProvinceResponse(
        id = this.id,
        name = this.name,
        cities = if (includeCities) this.cities.map { it.toResponse(includeNeighborhoods = includeNeighborhoods) } else null
    )
}