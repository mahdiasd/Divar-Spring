package com.divar.spring.core.parameter.service

import com.divar.spring.core.category.service.CategoryService
import com.divar.spring.core.parameter.entity.Parameter
import com.divar.spring.core.parameter.repository.ParameterRepository
import org.springframework.stereotype.Service

@Service
class ParameterService(
    val repository: ParameterRepository,
    val categoryService: CategoryService
) {

    fun save(value: Parameter): Parameter {
        return repository.save(value)
    }

    fun saveAll(values: List<Parameter>) {
        repository.saveAll(values)
    }

    fun findAll(): List<Parameter> {
        return repository.findAll()
    }

    fun findByCategory(categoryId: Long): List<Parameter>? {
        val parameters = repository.findAllByCategoryId(categoryId)
        if (parameters.isEmpty()) {
            var category = categoryService.findById(categoryId) ?: return null
            while (category.parent != null) {
                category = category.parent!!
                repository.findAllByCategoryId(category.id).takeIf { it.isNotEmpty() }?.let {
                    return it
                }
            }
        } else {
            return parameters
        }


        val list: MutableList<Long> = mutableListOf<Long>()
        list.add(categoryId)

        println(list.map { it })
        return repository.findAllByCategoryIdIn(list)
    }

    fun count(): Long {
        return repository.count()
    }

    fun findByIds(parameterIds: List<Long>): List<Parameter> {
        return repository.findAllByIdIn(parameterIds)
    }

    fun getReferenceById(id: Long): Parameter? {
        return try {
            repository.getReferenceById(id)
        } catch (e: Exception) {
            null
        }
    }
}