package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.LoungeEntity
import com.lunastratos.mudspoon.Entity.QLoungeEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QLoungeRepository  (
    val jpaQueryFactory: JPAQueryFactory
) {
    /***/
    fun selectBoardList(startPage: Long): List<LoungeEntity> {

        val item = QLoungeEntity.loungeEntity
        val res : List<LoungeEntity> = jpaQueryFactory.selectFrom(item)
            .orderBy(item.id.asc())
            .limit(10).offset(startPage)
            .fetch()
        return res
    }
    fun selectBoardSearchList(startPage: Long, search:String): List<LoungeEntity> {

        val item = QLoungeEntity.loungeEntity
        val res : List<LoungeEntity> = jpaQueryFactory.selectFrom(item)
            .where(item.auther.like(search).or(item.contents.like(search)))
            .orderBy(item.id.asc())
            .limit(10).offset(startPage)
            .fetch()
        return res
    }
}