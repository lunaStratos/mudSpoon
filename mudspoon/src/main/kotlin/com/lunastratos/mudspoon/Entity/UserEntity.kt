package com.lunastratos.mudspoon.Entity

import java.time.LocalDateTime
import javax.persistence.*

/**
 * 사용자 정보
 * */
@Entity
@Table(name ="t_user")
data class UserEntity (

    @Id
    @GeneratedValue
    val id : Long? = 0,
    @Column(name="email", length = 100, unique = true, nullable = false)
    val email :String? = "",
    @Column(name="password", length = 100, nullable = false)
    val password :String?= "",
    @Column(name="name", length = 100, nullable = false)
    val name :String? = "",
    @Column(name="roleType", length = 100, nullable = false)
    val roleType :RoleType?,
    @Column(name="updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @Column(name="created_at")
    val createdAt: LocalDateTime? = LocalDateTime.now()
)