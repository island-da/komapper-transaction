package com.test.usecase

import com.test.domain.order.Order
import com.test.domain.order.OrderService
import com.test.domain.product.Product
import com.test.domain.product.ProductAggregate
import com.test.domain.product.ProductRepository
import com.test.domain.product.ProductService
import com.test.domain.productattribute.ProductAttributeRepository
import com.test.domain.user.UserService
import com.test.usecase.dto.ProductOrderCommand
import com.test.usecase.dto.ProductQueryCommand
import com.test.usecase.queryservice.ProductQueryService
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional
@Component
class ProductUseCase(
    private val productQueryService: ProductQueryService,
    private val productService: ProductService,
    private val userService: UserService,
    private val orderService: OrderService,

    private val productRepository: ProductRepository,
    private val productAttributeRepository: ProductAttributeRepository,

) {
    fun getProducts(command: ProductQueryCommand): Flow<Product> {
        return productQueryService.getProducts(command.name, command.minPrice, command.maxPrice)
    }

    suspend fun getProductById(id: UUID): ProductAggregate {
        return productService.findById(id)
    }

    suspend fun updateProductById(id: UUID) {
        productRepository.update()
        productAttributeRepository.update()
    }

    suspend fun order(command: ProductOrderCommand): UUID {
        val user = userService.findById(command.userId)
        return orderService.order(Order.create(user.id, command.productId, command.quantity))
    }
}
