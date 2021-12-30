package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.MongoDB.LoungeEntity
import com.lunastratos.mudspoon.Entity.MongoDB.QLoungeEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.mongodb.core.query.where
import org.springframework.stereotype.Repository

@Repository
class QLoungeRepository  (
    val jpaQueryFactory: JPAQueryFactory
) {
    /***/
    fun selectBoardList(startPage: Long): List<LoungeEntity> {
        val item = QLoungeEntity.loungeEntity
        val res : List<LoungeEntity> = jpaQueryFactory.selectFrom(item)
            .limit(startPage).offset(10)
            .fetch()
        return res
    }
    fun selectBoardSearchList(startPage: Long, search:String): List<LoungeEntity> {
        val item = QLoungeEntity.loungeEntity
        val res : List<LoungeEntity> = jpaQueryFactory.selectFrom(item)
            .where(item.auther.like(search).or(item.contents.like(search)))
            .limit(startPage).offset(10)
            .fetch()
        return res
    }
}