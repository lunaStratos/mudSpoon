package com.lunastratos.mudspoon.Entity

import java.time.LocalDateTime
import javax.persistence.*

/**
 * 흙수저프랜즈 테이블
 *
 * */
@Entity
@Table(name ="t_sticker")
data class StickerEntity (

    @Id
    @GeneratedValue
    val id : Long? = 0,
    @Column(name="title")
    val title :String? = "",
    @Column(name="contents")
    val contents :String? = "",
    @Column(name="auther")
    val auther :String? = "",
    @Column(name="search_tag")
    val search_tag :String? = "",
    @Column(name="view_count")
    val view_count :Int? = 0,
    @Column(name="file_names") // 그림파일들 , 분리
    val file_names :String? = "",
    @Column(name="file_name_zip") // 압축파일
    val file_name_zip :String? = "",
    @Column(name="updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @Column(name="created_at")
    val createdAt: LocalDateTime? = LocalDateTime.now()
)