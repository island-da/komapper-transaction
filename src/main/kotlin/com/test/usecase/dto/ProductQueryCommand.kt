package com.test.usecase.dto

data class ProductQueryCommand(
    val name: String?,
    val minPrice: Int?,
    val maxPrice: Int?,
)
