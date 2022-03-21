package com.lunastratos.mudspoon.Entity

import java.time.LocalDateTime
import javax.persistence.*

/**
 * 흙수저프랜즈 테이블
 * */
@Entity
@Table(name ="t_sticker")
 class StickerEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long? = 0

    @Column(name = "title")
    var title: String? = ""

    @Column(name = "contents")
    var contents: String? = ""

    @Column(name = "auther")
    var auther: String? = ""

    @Column(name = "search_tag")
    var search_tag: String? = ""

    @Column(name = "view_count")
    var view_count: Int? = 0

    @Column(name = "file_folder") // 그림파일
    var file_folder: String? = ""

    @Column(name = "file_name_zip") // 압축파일
    var file_name_zip: String? = ""

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = LocalDateTime.now()

    @Column(name = "created_at")
    var createdAt: LocalDateTime? = LocalDateTime.now()

    @OneToMany(mappedBy = "stickerEntity" , fetch = FetchType.LAZY)
    private val stickerReplyList: List<StickerReplyEntity>? = null

}