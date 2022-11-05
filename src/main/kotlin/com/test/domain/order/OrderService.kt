package com.test.domain.order

import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderService(
    private val orderRepository: OrderRepository,
) {
    suspend fun order(order: Order): UUID {
        return orderRepository.create(order)
    }

    suspend fun findById(id: UUID): Order {
        return orderRepository.findById(id)
    }
}
