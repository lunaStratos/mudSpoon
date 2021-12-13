package com.lunastratos.mudspoon.Entity

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import javax.persistence.*

/**
 * 라운지 테이블
 * DB: 몽고 DB
 * */
@Document(collection = "t_lounge")
data class LoungeEntity (

    @Id
    @GeneratedValue
    val id : Long? = 0,
    @Column(name="auther")
    val auther :String? = "",
    @Column(name="contents")
    val contents :String?= "",
    @Column(name="updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @Column(name="created_at")
    val createdAt: LocalDateTime? = LocalDateTime.now()
)