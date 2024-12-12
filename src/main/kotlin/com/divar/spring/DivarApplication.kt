package com.divar.spring

import com.divar.spring.core.category.service.CategoryService
import com.divar.spring.core.location.service.CityService
import com.divar.spring.core.location.service.NeighborhoodService
import com.divar.spring.core.location.service.ProvinceService
import com.divar.spring.core.parameter.service.ParameterService
import com.divar.spring.utils.provider.CategoryDataProvider
import com.divar.spring.utils.provider.LocationDataProvider
import com.divar.spring.utils.provider.ParameterDataProvider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class DivarApplication

fun main(args: Array<String>) {
    val context = runApplication<DivarApplication>(*args)
    initLocations(context)
    initCategories(context)
    initParameters(context)
}


fun initParameters(context: ConfigurableApplicationContext) {
    val service = context.getBean(ParameterService::class.java)
    val categories = context.getBean(CategoryService::class.java).findAll()
    if (service.count() < 1)
        service.saveAll(ParameterDataProvider.getParameters(categories))
}

fun initCategories(context: ConfigurableApplicationContext) {
    val service = context.getBean(CategoryService::class.java)
    service.saveAll(CategoryDataProvider.getData())
}


fun initLocations(context: ConfigurableApplicationContext) {
    val provinceService = context.getBean(ProvinceService::class.java)
    val cityService = context.getBean(CityService::class.java)
    val neighborhoodService = context.getBean(NeighborhoodService::class.java)

    val triple = LocationDataProvider.getData()

    if (neighborhoodService.count() < 1) {
        provinceService.saveAll(triple.first)
        cityService.saveAll(triple.second)
        neighborhoodService.saveAll(triple.third)
    }
}
