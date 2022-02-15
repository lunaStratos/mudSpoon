package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.*
import com.querydsl.jpa.JPAExpressions
import com.querydsl.jpa.impl.JPAQueryFactory
import com.querydsl.sql.oracle.OracleGrammar.level
import org.springframework.stereotype.Repository


@Repository
class QOrderRepository  (
    val jpaQueryFactory: JPAQueryFactory
) {
    /***/
    fun findAllByQD(): List<User> {
        val user = QUser.user
        val article = QArticle.article
        val team = QTeam.team

        val res = jpaQueryFactory.select(user)
            .from(user)
            .leftJoin(user.articleList, article)
            .fetchJoin()
            .leftJoin(user.team, team)
            .fetchJoin()
            .distinct()
            .fetch()
        return res
    }

}