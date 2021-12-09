package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.QTestEntity
import com.lunastratos.mudspoon.Entity.TestEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class QTestRepository  (
    val entityManager: EntityManager,
    val jpaQueryFactory: JPAQueryFactory
) {
    fun selectAllTestEntity(): List<TestEntity> {
        val empList : List<TestEntity> = jpaQueryFactory.selectFrom(QTestEntity.testEntity).fetch()
        return empList
    }
}