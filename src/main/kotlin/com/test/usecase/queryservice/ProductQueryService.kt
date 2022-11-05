package com.test.usecase.queryservice

import com.test.domain.product.Product
import kotlinx.coroutines.flow.Flow

interface ProductQueryService {
    fun getProducts(name: String?, minPrice: Int?, maxPrice: Int?): Flow<Product>
}
