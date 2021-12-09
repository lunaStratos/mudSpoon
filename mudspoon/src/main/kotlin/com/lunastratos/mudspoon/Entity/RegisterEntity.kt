package com.lunastratos.mudspoon.Entity

import java.time.LocalDateTime
import javax.persistence.*

/**
 * 사용자 정보
 * */
data class RegisterEntity (

    @Column(name="email", length = 100, unique = true, nullable = false)
    val email :String? = "",
    @Column(name="password", length = 100, nullable = false)
    val password :String?= "",
    @Column(name="name", length = 100, nullable = false)
    val name :String? = "",
)