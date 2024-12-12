package com.divar.spring.core.location.dto

import com.divar.spring.core.location.entity.Neighborhood

data class NeighborhoodResponse(
    val id: Long,
    val name: String,
)

fun Neighborhood.toResponse(): NeighborhoodResponse {
    return NeighborhoodResponse(id = this.id, name = this.name)
}