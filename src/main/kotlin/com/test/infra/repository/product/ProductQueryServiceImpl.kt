package com.test.infra.repository.product

import com.test.domain.product.Product
import com.test.domain.product.product
import com.test.usecase.queryservice.ProductQueryService
import kotlinx.coroutines.flow.Flow
import org.komapper.core.dsl.Meta
import org.komapper.core.dsl.QueryDsl
import org.komapper.r2dbc.R2dbcDatabase
import org.springframework.stereotype.Repository

@Repository
class ProductQueryServiceImpl(
    private val db: R2dbcDatabase,
) : ProductQueryService {

    override fun getProducts(name: String?, minPrice: Int?, maxPrice: Int?): Flow<Product> {
        return db.flowQuery {
            val p = Meta.product
            QueryDsl.from(p).where {
                p.name like name?.let { "%$name%" }
                p.price greaterEq minPrice
                p.price lessEq maxPrice
            }
        }
    }
}
