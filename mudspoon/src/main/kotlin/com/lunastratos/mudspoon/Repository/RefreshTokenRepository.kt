package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.RefreshTokenEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*
@Repository
interface RefreshTokenRepository: CrudRepository<RefreshTokenEntity, String?> {
}