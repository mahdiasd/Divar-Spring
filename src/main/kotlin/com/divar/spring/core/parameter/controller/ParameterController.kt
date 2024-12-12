package com.divar.spring.core.parameter.controller

import com.divar.spring.core.parameter.dto.toResponse
import com.divar.spring.core.parameter.service.ParameterService
import com.divar.spring.utils.response.ApiResponse
import com.divar.spring.utils.response.GoneError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class ParameterController(val service: ParameterService) {

    @GetMapping("parameter")
    fun getParameters(
        @RequestParam("categoryId") categoryId: Long? = null
    ): ResponseEntity<*> {
        return if (categoryId == null)
            ApiResponse.success(service.findAll().map { it.toResponse() })
        else {
            service.findByCategory(categoryId)?.map { it.toResponse(includeCategories = false) }?.let {
                ApiResponse.success(it)
            } ?: run {
                ApiResponse.error(GoneError(message = "دسته بندی پیدا نشد!"))
            }
        }
    }
}