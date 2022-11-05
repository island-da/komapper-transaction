package com.test.domain.product

import org.komapper.annotation.*
import java.time.LocalDateTime
import java.util.*

@KomapperEntity
@KomapperTable("products")
data class Product(
    @KomapperId val id: UUID,
    val name: String,
    val price: Int,
    @KomapperCreatedAt val createdAt: LocalDateTime? = null,
    @KomapperUpdatedAt val updatedAt: LocalDateTime? = null,
)
