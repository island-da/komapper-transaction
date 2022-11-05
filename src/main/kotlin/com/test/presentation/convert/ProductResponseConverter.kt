package com.test.presentation.convert

import com.test.domain.product.Product
import com.test.domain.product.ProductAggregate
import com.test.presentation.response.ProductDetailResponse
import com.test.presentation.response.ProductResponse
import com.test.presentation.response.ProductsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList

suspend fun Flow<Product>.toResponse(): ProductsResponse =
    ProductsResponse(
        products = this.toList().map { it.toResponse() }
    )

fun Product.toResponse(): ProductResponse =
    ProductResponse(
        id = this.id.toString(),
        name = this.name,
        price = this.price,
    )

fun ProductAggregate.toResponse(): ProductDetailResponse =
    ProductDetailResponse(
        id = this.productId.toString(),
        name = this.name,
        price = this.price,
        status = this.status,
        description = this.description,
        imagePath = this.imagePath,
    )
