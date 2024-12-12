package com.divar.spring.core.category.controller

import com.divar.spring.core.category.dto.toResponse
import com.divar.spring.core.category.service.CategoryService
import com.divar.spring.utils.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/")
class CategoryController(val service: CategoryService) {

    @GetMapping("category")
    fun getCategories(): ResponseEntity<*> {
        return ApiResponse.success(service.findAll().map { it.toResponse() })
    }


}