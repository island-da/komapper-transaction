package com.test.domain.product

import java.util.*

interface ProductRepository {
    suspend fun findById(id: UUID): ProductAggregate

    suspend fun update()
}
