package com.test.domain.user

import org.komapper.annotation.*
import java.time.LocalDateTime
import java.util.*

@KomapperEntity
@KomapperTable("users")
data class User(
    @KomapperId val id: UUID,
    val name: String,
    val email: String,
    val tel: String,
    val postCode: String,
    val address: String,
    @KomapperCreatedAt val createdAt: LocalDateTime? = null,
    @KomapperUpdatedAt val updatedAt: LocalDateTime? = null,
)
