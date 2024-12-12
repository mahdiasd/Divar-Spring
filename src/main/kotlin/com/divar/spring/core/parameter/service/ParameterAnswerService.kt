package com.divar.spring.core.parameter.service

import com.divar.spring.core.category.service.CategoryService
import com.divar.spring.core.parameter.entity.ParameterAnswer
import com.divar.spring.core.parameter.repository.ParameterAnswerRepository
import org.springframework.stereotype.Service

@Service
class ParameterAnswerService(
    val repository: ParameterAnswerRepository,
    val categoryService: CategoryService
) {

    fun save(value: ParameterAnswer): ParameterAnswer {
        return repository.save(value)
    }

    fun saveAll(values: List<ParameterAnswer>) {
        repository.saveAll(values)
    }

    fun findAll(): List<ParameterAnswer> {
        return repository.findAll()
    }


    fun count(): Long {
        return repository.count()
    }

}