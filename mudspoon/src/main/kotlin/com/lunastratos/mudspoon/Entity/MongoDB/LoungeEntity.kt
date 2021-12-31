package com.lunastratos.mudspoon.Entity.MongoDB

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
//@Entity
//@QueryEntity
//@Document(collection = "t_lounge")
//data class LoungeEntity (
//
//    @Id
//    val id : Long? = 0,
//    @Field("auther")
//    val auther :String? = "",
//    @Field("contents")
//    val contents :String?= "",
//    @Field("updatedAt")
//    val updated_at: LocalDateTime? = LocalDateTime.now(),
//    @Field("created_at")
//    val createdAt: LocalDateTime? = LocalDateTime.now()
//)