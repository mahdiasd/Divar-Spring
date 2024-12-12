package com.divar.spring.core.category.repository

import com.divar.spring.core.category.entity.Category
import com.divar.spring.core.location.entity.City
import com.divar.spring.core.location.entity.Province
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {

}