package com.test.infra.repository.product

import com.test.usecase.queryservice.ProductQueryService
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.stream.Stream

@SpringBootTest
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class ProductQueryServiceTest @Autowired constructor(
    private val productQueryService: ProductQueryService,
) {
    @ParameterizedTest
    @MethodSource("productPattern")
    fun `商品を絞り込み取得できること`(name: String?, minPrice: Int?, maxPrice: Int?, count: Int) = runTest {
        val actual = productQueryService.getProducts(name, minPrice, maxPrice)
        assertEquals(count, actual.toList().size)
    }

    companion object {
        @JvmStatic
        fun productPattern(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("商", null, null, 3),
                Arguments.arguments("品", null, null, 3),
                Arguments.arguments("A", null, null, 1),
                Arguments.arguments(null, 6999, null, 3),
                Arguments.arguments(null, 7000, null, 3),
                Arguments.arguments(null, 7001, null, 2),
                Arguments.arguments(null, null, 9001, 3),
                Arguments.arguments(null, null, 9000, 3),
                Arguments.arguments(null, null, 8999, 2),
                Arguments.arguments(null, 8000, 9000, 2),
                Arguments.arguments("C", 8000, 9000, 1),
                Arguments.arguments(null, null, null, 3),
            )
        }
    }
}
