package com.lunastratos.mudspoon.Repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QLoungeRepository  (
    val jpaQueryFactory: JPAQueryFactory
) {
    /***/
//    fun selectBoardList(page: Int, title:String): List<LoungeEntity> {
//        val res : List<LoungeEntity> = jpaQueryFactory.selectFrom(QLounge).whe
//            .fetch()
//        return res
//    }
}