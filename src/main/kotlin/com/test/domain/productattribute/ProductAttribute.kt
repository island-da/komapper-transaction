package com.test.domain.productattribute

import org.komapper.annotation.*
import java.time.LocalDateTime
import java.util.*

@KomapperEntity
@KomapperTable("product_attributes")
data class ProductAttribute(
    @KomapperId val id: UUID,
    val productId: UUID,
    val status: String,
    val description: String,
    val imagePath: String,
    @KomapperCreatedAt val createdAt: LocalDateTime? = null,
    @KomapperUpdatedAt val updatedAt: LocalDateTime? = null,
)
