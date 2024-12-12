package com.divar.spring.core.ads.dto

data class CategoriesOfAds(
    val categoryName: String,
    val categoryId: Long,
    val adsCount: Long,
    val adsTitle: String
)
