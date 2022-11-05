package com.test.infra.repository.order

import com.test.domain.order.Order
import com.test.domain.order.OrderRepository
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.komapper.r2dbc.R2dbcDatabase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class OrderRepositoryTest @Autowired constructor(
    private val db: R2dbcDatabase,
    private val orderRepository: OrderRepository,
) {
    @Test
    fun `オーダーを登録して取得できること`() = runTest {
        val orderId = UUID.randomUUID()
        val expected = Order(
            id = orderId,
            userId = UUID.fromString("3029bea7-fcf3-4fef-8fbc-754f111f3b56"),
            productId = UUID.fromString("039b4506-f78a-48b0-9505-64acf8b3011e"),
            quantity = 1,
        )

        db.withTransaction { tx ->
            // 登録
            val actual = orderRepository.create(expected)
            assertEquals(orderId, actual)

            // 取得
            val result = orderRepository.findById(orderId)
            assertThat(expected)
                .usingRecursiveComparison()
                .ignoringFields("createdAt", "updatedAt")
                .isEqualTo(result)

            // ロールバック
            tx.setRollbackOnly()
        }
    }
}
