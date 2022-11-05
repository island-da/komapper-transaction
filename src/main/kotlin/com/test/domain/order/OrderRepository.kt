package com.test.domain.order

import java.util.*

interface OrderRepository {
    suspend fun create(order: Order): UUID
    suspend fun findById(id: UUID): Order
}
