package com.lunastratos.mudspoon.Entity

import com.querydsl.core.annotations.QueryEntity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
import javax.persistence.*

/**
 * 라운지 테이블
 * DB: 몽고 DB
 * @Entity를 써야 QueryDSL에서 인식
 * */
@Entity
@Table(name ="t_lounge")
data class LoungeEntity (

    @Id
    @GeneratedValue
    var id : Long? = 0,
    @Column(name = "auther")
    var auther :String? = "",
    @Column(name ="contents")
    var contents :String?= "",
    @Column(name ="updatedAt")
    val updated_at: LocalDateTime? = LocalDateTime.now(),
    @Column(name ="created_at")
    val createdAt: LocalDateTime? = LocalDateTime.now()
)