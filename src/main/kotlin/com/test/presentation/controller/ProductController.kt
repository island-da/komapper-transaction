package com.test.presentation.controller

import com.test.presentation.convert.toResponse
import com.test.presentation.request.GetProductsRequest
import com.test.presentation.request.OrderProductRequest
import com.test.presentation.response.ProductDetailResponse
import com.test.presentation.response.ProductOrderResponse
import com.test.presentation.response.ProductResponse
import com.test.presentation.response.ProductsResponse
import com.test.usecase.ProductUseCase
import com.test.usecase.dto.ProductOrderCommand
import com.test.usecase.dto.ProductQueryCommand
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ProductController(
    private val productUseCase: ProductUseCase,
) {
    @PostMapping(path = ["/products"])
    suspend fun getProducts(
        @RequestBody request: GetProductsRequest,
    ): ResponseEntity<ProductsResponse> {
        val query = ProductQueryCommand(
            name = request.name,
            minPrice = request.minPrice,
            maxPrice = request.maxPrice,
        )
        val products = productUseCase.getProducts(query)
        val body = products.toResponse()
        return ResponseEntity.ok(body)
    }

    @GetMapping(path = ["/products/{id}"])
    suspend fun getProductById(
        @PathVariable(name = "id", required = true) id: UUID,
    ): ResponseEntity<ProductDetailResponse> {
        val product = productUseCase.getProductById(id)
        val body = product.toResponse()
        return ResponseEntity.ok(body)
    }

    @PostMapping(path = ["/products/{id}/order"])
    suspend fun orderProduct(
        @PathVariable(name = "id", required = true) id: UUID,
        @RequestBody request: OrderProductRequest,
    ): ResponseEntity<ProductOrderResponse> {
        val result = productUseCase.order(
            command = ProductOrderCommand(
                userId = request.userId,
                productId = id,
                quantity = request.quantity,
            )
        )
        return ResponseEntity.ok(ProductOrderResponse(result.toString()))
    }

    @PutMapping(path = ["/products/{id}"])
    suspend fun updateProduct(
        @PathVariable(name = "id", required = true) id: UUID,
    ): ResponseEntity<Unit> {
        productUseCase.updateProductById(id)
        return ResponseEntity.ok(Unit)
    }
}
