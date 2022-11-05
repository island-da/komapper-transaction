package com.test.infra.repository.product

import com.test.domain.product.ProductAggregate
import com.test.domain.product.ProductRepository
import com.test.domain.product.product
import com.test.domain.productattribute.productAttribute
import org.komapper.core.dsl.Meta
import org.komapper.core.dsl.QueryDsl
import org.komapper.core.dsl.query.singleOrNull
import org.komapper.r2dbc.R2dbcDatabase
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProductRepositoryImpl(
    private val db: R2dbcDatabase,
) : ProductRepository {

    override suspend fun findById(id: UUID): ProductAggregate {
        val p = Meta.product
        val pa = Meta.productAttribute
        val record = db.runQuery {
            QueryDsl
                .from(p)
                .innerJoin(pa) { p.id eq pa.productId }
                .where { p.id eq id }
                .select(p.id, p.name, p.price, pa.status, pa.description, pa.imagePath)
                .singleOrNull()
        } ?: throw RuntimeException("商品が存在しません")
        return ProductAggregate(
            productId = record[p.id]!!,
            name = record[p.name]!!,
            price = record[p.price]!!,
            status = record[pa.status]!!,
            description = record[pa.description]!!,
            imagePath = record[pa.imagePath]!!,
        )
    }

    override suspend fun update() {
        db.runQuery {
            val p = Meta.product
            QueryDsl.update(p).set { p.name eq "商品AA" }
                .where { p.id eq UUID.fromString("039b4506-f78a-48b0-9505-64acf8b3011e") }
        }
    }
}
