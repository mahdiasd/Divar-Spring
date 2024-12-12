package com.divar.spring.core.parameter.entity

import com.divar.spring.core.ads.entity.Ads
import com.divar.spring.core.category.entity.Category
import jakarta.persistence.*


@Entity(name = "parameter_answer")
data class ParameterAnswer(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val answer: String,

    @ManyToOne
    @JoinColumn(name = "ads_id")
    val ads: Ads,

    @ManyToOne
    @JoinColumn(name = "parameter_id")
    val parameter: Parameter,
)
