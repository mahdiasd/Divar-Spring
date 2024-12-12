package com.divar.spring.core.location.service

import com.divar.spring.core.location.entity.City
import com.divar.spring.core.location.entity.Province
import com.divar.spring.core.location.repository.CityRepository
import org.springframework.stereotype.Service

@Service
class CityService(
    val repository: CityRepository
) {

    fun findAll(): List<City> {
        return repository.findAll()
    }

    fun saveAll(entity: List<City>): MutableList<City> {
        return repository.saveAll(entity)
    }

    fun save(entity: City): City {
        return repository.save(entity)
    }

    fun count(): Long {
        return repository.count()
    }
}