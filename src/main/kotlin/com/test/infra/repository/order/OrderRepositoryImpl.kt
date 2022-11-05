package com.test.infra.repository.order

import com.test.domain.order.Order
import com.test.domain.order.OrderRepository
import com.test.domain.order.order
import org.komapper.core.dsl.Meta
import org.komapper.core.dsl.QueryDsl
import org.komapper.core.dsl.query.singleOrNull
import org.komapper.r2dbc.R2dbcDatabase
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class OrderRepositoryImpl(
    private val db: R2dbcDatabase,
) : OrderRepository {

    override suspend fun create(order: Order): UUID {
        return db.runQuery {
            val o = Meta.order
            QueryDsl.insert(o).single(order)
        }.id
    }

    override suspend fun findById(id: UUID): Order {
        return db.runQuery {
            val o = Meta.order
            QueryDsl.from(o).where { o.id eq id }.singleOrNull()
        } ?: throw RuntimeException("オーダーがありません")
    }
}
