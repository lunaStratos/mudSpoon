package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.QTestEntity
import com.lunastratos.mudspoon.Entity.StickerEntity
import com.lunastratos.mudspoon.Entity.TestEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class QStickerRepository  (
    val jpaQueryFactory: JPAQueryFactory
) {
    fun selectBoardNum(boardNum:Long): List<StickerEntity> {
        val item = QStickerEntity.stickerEntity
        val empList : List<StickerEntity> =
            jpaQueryFactory.selectFrom(item)
                .where(item.id.eq(boardNum))
                .fetch()
        return empList
    }

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
}