package com.lunastratos.mudspoon.Config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class QueryDslConfiguration (
    @PersistenceContext
    val entityManager: EntityManager
    ){

    //Repository에서 JPAQueryFactory를 주입받아 Querydsl을 사용할 수 있게 합니다.
    @Bean
    fun jpaQueryFactory () = JPAQueryFactory(entityManager)
}