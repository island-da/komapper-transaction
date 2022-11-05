package com.test.domain.user

import java.util.*

interface UserRepository {
    suspend fun findById(id: UUID): User
}
