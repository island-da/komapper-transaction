package com.test.usecase

import com.test.domain.order.Order
import com.test.domain.order.OrderService
import org.springframework.stereotype.Component
import java.util.*

@Component
class OrderUseCase(
    private val orderService: OrderService,
) {
    suspend fun getOrderById(id: UUID): Order {
        return orderService.findById(id)
    }
}
