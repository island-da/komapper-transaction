package com.test.presentation.convert

import com.test.domain.order.Order
import com.test.presentation.response.OrderResponse

fun Order.toResponse(): OrderResponse =
    OrderResponse(
        id = this.id.toString(),
        userId = this.userId.toString(),
        productId = this.productId.toString(),
        quantity = this.quantity,
        createdAt = this.createdAt!!,
    )
