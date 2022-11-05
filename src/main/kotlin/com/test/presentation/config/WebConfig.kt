package com.test.presentation.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer

@EnableWebFlux
@Configuration
class WebConfig : WebFluxConfigurer {

    private val allowedMethods = listOf(
        "OPTIONS",
        "GET",
        "POST",
        "PUT",
        "DELETE",
    )

    override fun addCorsMappings(registry: CorsRegistry) {
        registry
            .addMapping("/**")
            .allowedMethods(*allowedMethods.toTypedArray())
            .allowedOrigins("*")
    }

    override fun configureHttpMessageCodecs(configurer: ServerCodecConfigurer) {
        val objectMapper = ObjectMapper().apply {
            registerModule(JavaTimeModule())
            registerKotlinModule()

            setSerializationInclusion(JsonInclude.Include.NON_NULL)
            disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)

            disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
        }

        configurer
            .defaultCodecs()
            .jackson2JsonEncoder(Jackson2JsonEncoder(objectMapper))

        configurer
            .defaultCodecs()
            .jackson2JsonDecoder(Jackson2JsonDecoder(objectMapper))
    }
}
