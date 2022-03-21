package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.*
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QStickerRepository  (
    val jpaQueryFactory: JPAQueryFactory
) {

    /**
     * 게시판 조회
     * */
    fun selectBoardList(startPage:Long): List<StickerEntity> {
        val item = QStickerEntity.stickerEntity
        val empList : List<StickerEntity> =
            jpaQueryFactory.selectFrom(item)
                .orderBy(item.id.asc())
                .limit(10).offset(startPage)
                .fetch()
        return empList
    }

    fun deleteBoardNum(boardNum: Long):Long{
        val item = QStickerEntity.stickerEntity
        val response = jpaQueryFactory.delete(item).where(item.id.eq(boardNum)).execute()
        return response
    }

    /**
     * 게시판 조회 (검색)
     * */
    fun selectBoardSearchList(startPage: Long, search:String): List<StickerEntity> {

        val item = QStickerEntity.stickerEntity

        val res : List<StickerEntity> = jpaQueryFactory.selectFrom(item)
            .where(item.auther.like(search).or(item.contents.like(search)))
            .orderBy(item.id.asc())
            .limit(10).offset(startPage)
            .fetch()
        return res
    }

    /**
     * 게시물 조회
     * */
    fun selectBoardNum(boardNum:Long): List<StickerEntity> {
        val item = QStickerEntity.stickerEntity
        val empList : List<StickerEntity> =
            jpaQueryFactory.selectFrom(item)
                .where(item.id.eq(boardNum))
                .fetch()
        return empList
    }

    /**
     * 글쓰기
     * */
    fun insertSticker(stickerEntity:StickerEntity): Long{
        val item = QStickerEntity.stickerEntity
        val result:Long  =
            jpaQueryFactory.insert(item)
                .columns(
                    item.auther,
                    item.contents,
                    item.file_name_zip,
                    item.file_folder,
                    item.search_tag,
                    item.title,
                )
                .values(
                    stickerEntity.auther,
                    stickerEntity.contents,
                    stickerEntity.file_name_zip,
                    stickerEntity.file_folder,
                    stickerEntity.search_tag,
                    stickerEntity.title
                ).execute()

        return result
    }

    fun findAll(): List<StickerEntity> {
        val item = QStickerEntity.stickerEntity
        val empList : List<StickerEntity> =
            jpaQueryFactory.selectFrom(item)
                .fetch()
        return empList
    }

    fun findAllSolve(): List<StickerEntity> {
        val stickerEntity = QStickerEntity.stickerEntity
        val stickerReplyEntity = QStickerReplyEntity.stickerReplyEntity
        val empList : List<StickerEntity> =
            jpaQueryFactory.select(stickerEntity)
                .from(stickerEntity)
                .leftJoin(stickerEntity.stickerReplyList, stickerReplyEntity)
                .fetchJoin()
                .distinct()
                .fetch()
        return empList
    }
}