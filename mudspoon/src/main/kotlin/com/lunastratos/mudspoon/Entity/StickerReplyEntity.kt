package com.lunastratos.mudspoon.Entity

import java.time.LocalDateTime
import javax.persistence.*

/**
 * 흙수저프랜즈 리플 테이블
 * */
@Entity
@Table(name ="t_sticker_reply")
 class StickerReplyEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long? = 0

    @Column(name = "sticker_id")
    val stickerId :Long?= 0

    @Column(name = "auther")
    val auther: String? = ""

    @Column(name = "contents")
    val contents: String? = ""

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now()

    @Column(name = "created_at")
    val createdAt: LocalDateTime? = LocalDateTime.now()

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sticker_entity_id")
    private val stickerEntity: StickerEntity? = null

}