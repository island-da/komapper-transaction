package com.test.infra.repository.user

import com.test.domain.user.User
import com.test.domain.user.UserRepository
import com.test.domain.user.user
import org.komapper.core.dsl.Meta
import org.komapper.core.dsl.QueryDsl
import org.komapper.core.dsl.query.singleOrNull
import org.komapper.r2dbc.R2dbcDatabase
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepositoryImpl(
    private val db: R2dbcDatabase,
) : UserRepository {

    override suspend fun findById(id: UUID): User {
        return db.runQuery {
            val u = Meta.user
            QueryDsl.from(u).where { u.id eq id }.singleOrNull()
        } ?: throw RuntimeException("ユーザが存在しません")
    }
}
