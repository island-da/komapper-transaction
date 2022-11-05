package com.test.presentation.controller

import com.test.presentation.convert.toResponse
import com.test.presentation.response.OrderResponse
import com.test.usecase.OrderUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class OrderController(
    private val orderUseCase: OrderUseCase,
) {
    @GetMapping(path = ["/orders/{id}"])
    suspend fun getOrderById(
        @PathVariable(name = "id", required = true) id: UUID,
    ): ResponseEntity<OrderResponse> {
        val order = orderUseCase.getOrderById(id)
        val body = order.toResponse()
        return ResponseEntity.ok(body)
    }
}
