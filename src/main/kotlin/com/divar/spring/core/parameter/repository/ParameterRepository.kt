package com.divar.spring.core.parameter.repository

import com.divar.spring.core.parameter.entity.Parameter
import org.springframework.data.jpa.repository.JpaRepository

interface ParameterRepository : JpaRepository<Parameter, Long> {
    fun findAllByCategoryId(categoryId: Long): List<Parameter>

    fun findAllByCategoryIdIn(categoryIds: List<Long>): List<Parameter>
    fun findAllByIdIn(ids: List<Long>): List<Parameter>
}