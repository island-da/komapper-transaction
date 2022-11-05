package com.test.domain.product

import java.util.*

data class ProductAggregate(
    val productId: UUID,
    val name: String,
    val price: Int,
    val status: String,
    val description: String,
    val imagePath: String,
)
