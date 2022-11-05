package com.test.infra.repository.productattribute

import com.test.domain.productattribute.ProductAttributeRepository
import com.test.domain.productattribute.productAttribute
import org.komapper.core.dsl.Meta
import org.komapper.core.dsl.QueryDsl
import org.komapper.r2dbc.R2dbcDatabase
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProductAttributeRepositoryImpl(
    private val db: R2dbcDatabase,
) : ProductAttributeRepository {

    override suspend fun update() {
        val random = (1..10).random()
        val status = if (random > 6) {
            "ステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータスステータス"
        } else "AAA"
        val pa = Meta.productAttribute
        db.runQuery {
            QueryDsl.update(pa).set { pa.status eq status }
                .where { pa.id eq UUID.fromString("52c48db8-af93-44c8-a085-7f2c237b3839") }
        }
    }
}
