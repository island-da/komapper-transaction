package com.test.presentation.request

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class OrderProductRequest(
    @JsonProperty("user_id") val userId: UUID,
    @JsonProperty("quantity") val quantity: Int,
)
