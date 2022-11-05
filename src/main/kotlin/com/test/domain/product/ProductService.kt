package com.test.domain.product

import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {
    suspend fun findById(id: UUID): ProductAggregate {
        return productRepository.findById(id)
    }
}
