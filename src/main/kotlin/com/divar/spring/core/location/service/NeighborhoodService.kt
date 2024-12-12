package com.divar.spring.core.location.service

import com.divar.spring.core.location.entity.City
import com.divar.spring.core.location.entity.Neighborhood
import com.divar.spring.core.location.repository.NeighborhoodRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class NeighborhoodService(
    val repository: NeighborhoodRepository
) {

    fun findAll(): List<Neighborhood> {
        return repository.findAll()
    }

    fun findById(id: Long): Neighborhood? {
        return repository.findById(id).getOrNull()
    }

    fun getReferenceById(id: Long): Neighborhood? {
        return try {
            repository.getReferenceById(id)
        } catch (ex: Exception) {
            null
        }
    }

    fun save(entity: Neighborhood): Neighborhood {
        return repository.save(entity)
    }

    fun saveAll(entity: List<Neighborhood>): MutableList<Neighborhood> {
        return repository.saveAll(entity)
    }


    fun count(): Long {
        return repository.count()
    }
}