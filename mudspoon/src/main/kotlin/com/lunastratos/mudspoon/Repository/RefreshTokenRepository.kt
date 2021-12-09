package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface RefreshTokenRepository: JpaRepository<RefreshToken?, Long?> {
    fun findByKey(key: String?): Optional<RefreshToken?>
}