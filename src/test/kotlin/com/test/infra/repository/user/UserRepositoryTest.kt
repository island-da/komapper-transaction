package com.test.infra.repository.user

import com.test.domain.user.User
import com.test.domain.user.UserRepository
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class UserRepositoryTest @Autowired constructor(
    private val userRepository: UserRepository,
) {
    @Test
    fun `ユーザを取得できること`() = runTest {
        val expected = User(
            id = UUID.fromString("3029bea7-fcf3-4fef-8fbc-754f111f3b56"),
            name = "ユーザ1",
            email = "example@example.com",
            tel = "03-1234-5678",
            postCode = "135-0001",
            address = "東京都千代田区1-1"
        )
        val actual = userRepository.findById(UUID.fromString("3029bea7-fcf3-4fef-8fbc-754f111f3b56"))
        assertThat(expected)
            .usingRecursiveComparison()
            .ignoringFields("createdAt", "updatedAt")
            .isEqualTo(actual)
    }
}
