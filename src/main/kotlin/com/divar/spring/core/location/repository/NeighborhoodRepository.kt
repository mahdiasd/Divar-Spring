package com.divar.spring.core.location.repository

import com.divar.spring.core.location.entity.Neighborhood
import com.divar.spring.core.location.entity.Province
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NeighborhoodRepository : JpaRepository<Neighborhood, Long> {

}