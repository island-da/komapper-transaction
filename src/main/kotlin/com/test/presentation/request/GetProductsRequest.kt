package com.test.presentation.request

import com.fasterxml.jackson.annotation.JsonProperty

data class GetProductsRequest(
    @JsonProperty("name") val name: String?,
    @JsonProperty("min_price") val minPrice: Int?,
    @JsonProperty("max_price") val maxPrice: Int?,
)
