package com.test.domain.user

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    suspend fun findById(id: UUID): User {
        return userRepository.findById(id)
    }
}
