package com.test.domain.order

import org.komapper.annotation.*
import java.time.LocalDateTime
import java.util.*

@KomapperEntity
@KomapperTable("orders")
data class Order(
    @KomapperId val id: UUID,
    val userId: UUID,
    val productId: UUID,
    val quantity: Int,
    @KomapperCreatedAt val createdAt: LocalDateTime? = null,
    @KomapperUpdatedAt val updatedAt: LocalDateTime? = null,
) {
    companion object {
        fun create(
            userId: UUID,
            productId: UUID,
            quantity: Int,
        ): Order =
            Order(
                id = UUID.randomUUID(),
                userId,
                productId,
                quantity
            )
    }
}
