package com.test.presentation.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class OrderResponse(
    val id: String,
    @JsonProperty("user_id") val userId: String,
    @JsonProperty("product_id") val productId: String,
    val quantity: Int,
    @JsonProperty("created_at") val createdAt: LocalDateTime,
)
