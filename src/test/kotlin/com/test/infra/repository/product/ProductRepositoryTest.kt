package com.test.infra.repository.product

import com.test.domain.product.ProductAggregate
import com.test.domain.product.ProductRepository
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class ProductRepositoryTest @Autowired constructor(
    private val productRepository: ProductRepository,
) {
    @Test
    fun `商品を取得できること`() = runTest {
        val expected = ProductAggregate(
            productId = UUID.fromString("039b4506-f78a-48b0-9505-64acf8b3011e"),
            name = "商品A",
            price = 8000,
            status = "A",
            description = "説明文",
            imagePath = "/image/a.png",
        )
        val actual = productRepository.findById(UUID.fromString("039b4506-f78a-48b0-9505-64acf8b3011e"))
        assertEquals(expected, actual)
    }
}
