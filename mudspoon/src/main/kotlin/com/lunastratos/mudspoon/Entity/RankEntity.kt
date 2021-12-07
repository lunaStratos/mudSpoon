package com.lunastratos.mudspoon.Entity

import java.time.LocalDateTime
import javax.persistence.*

/**
 * 랭킹 테이블
 * */
@Entity
@Table(name ="t_rank")
data class RankEntity (

    @Id
    @GeneratedValue
    val id : Long? = 0,
    @Column(name="rank")
    val rank :String? = "",
    @Column(name="title")
    val title :String? = "",
    @Column(name="title_id")
    val title_id :String? = "",
    @Column(name="updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @Column(name="created_at")
    val createdAt: LocalDateTime? = LocalDateTime.now()
)