package com.divar.spring.core.location.entity

import jakarta.persistence.*

@Entity(name = "neighborhood")
data class Neighborhood(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String,

    @ManyToOne
    @JoinColumn(name = "city_id")
    val city: City
)
