package com.divar.spring.core.location.dto

import com.divar.spring.core.location.entity.City

data class CityResponse(
    val id: Long,
    val name: String,
    val neighborhoods: List<NeighborhoodResponse>? = null
)

fun City.toResponse(includeNeighborhoods: Boolean = true): CityResponse {
    return CityResponse(
        id = this.id,
        name = this.name,
        neighborhoods = if (includeNeighborhoods) neighborhoods.map { it.toResponse() } else null
    )
}