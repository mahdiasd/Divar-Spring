package com.divar.spring.core.location.controller

import com.divar.spring.core.location.dto.toResponse
import com.divar.spring.core.location.service.ProvinceService
import com.divar.spring.utils.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class LocationController(val service: ProvinceService) {


    @GetMapping("location")
    fun getLocations(
        @RequestParam("includeCities") includeCities: Boolean? = true,
        @RequestParam("includeNeighborhood") includeNeighborhood: Boolean? = true
    ): ResponseEntity<*> {
        return ApiResponse.success(service.findAll().map {
            it.toResponse(
                includeCities = includeCities ?: true,
                includeNeighborhoods = includeNeighborhood ?: true
            )
        })
    }

}