package com.test.usecase.dto

import java.util.*

data class ProductOrderCommand(
    val userId: UUID,
    val productId: UUID,
    val quantity: Int,
)
