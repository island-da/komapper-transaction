package com.test.presentation.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductOrderResponse(
    @JsonProperty("order_id") val orderId: String,
)
