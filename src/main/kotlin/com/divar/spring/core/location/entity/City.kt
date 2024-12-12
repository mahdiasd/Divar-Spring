package com.divar.spring.core.location.entity

import jakarta.persistence.*

@Entity(name = "city")
data class City(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    @ManyToOne
    @JoinColumn(name = "province_id")
    val province: Province,

    @OneToMany(mappedBy = "city")
    val neighborhoods: List<Neighborhood> = listOf()
)
