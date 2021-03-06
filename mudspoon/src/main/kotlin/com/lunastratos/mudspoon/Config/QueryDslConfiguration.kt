package com.lunastratos.mudspoon.Config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


/**
 * QueryDslConfiguration
 * desc: QueryDSL config 모듈
 * Configuration & Bean으로 싱글톤 적용
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-19 초기작성
 *
 * @date        2021-12-19
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@Configuration
class QueryDslConfiguration (
    @PersistenceContext
    private var entityManager: EntityManager
    ){

    //Repository에서 JPAQueryFactory를 주입받아 Querydsl을 사용할 수 있게 합니다.
    @Bean
    fun jpaQueryFactory () = JPAQueryFactory(entityManager)

}