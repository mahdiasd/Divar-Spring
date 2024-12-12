package com.divar.spring.core.parameter.entity

import com.divar.spring.core.category.entity.Category
import jakarta.persistence.*

enum class DataType {
    StringInput,
    NumberInput,
    FloatInput,
    CheckBoxInput,
    FixedOption
}

@Entity(name = "parameter")
data class Parameter(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val dataType: DataType,

    val acceptedOptions: String? = null,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category,
)
