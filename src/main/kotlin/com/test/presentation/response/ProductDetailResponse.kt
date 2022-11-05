package com.test.presentation.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductDetailResponse(
    val id: String,
    val name: String,
    val price: Int,
    val status: String,
    val description: String,
    @JsonProperty("image_path") val imagePath: String,
)
