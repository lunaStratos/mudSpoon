package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.QTestEntity
import com.lunastratos.mudspoon.Entity.QUserEntity
import com.lunastratos.mudspoon.Entity.TestEntity
import com.lunastratos.mudspoon.Entity.UserEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class QUserRepository (
    val entityManager: EntityManager,
    val query: JPAQueryFactory
) {
    fun selectUserByEmailAndPw(username: String): List<UserEntity> {
        val userQEM = QUserEntity.userEntity
        val userEntity : List<UserEntity> = query.selectFrom(userQEM)
            .where(userQEM.email.eq(username), userQEM.password.eq("test"))
            .fetch()
        return userEntity
    }

    fun selectUserByEmail(username: String): List<UserEntity> {
        val userQEM = QUserEntity.userEntity
        val userEntity : List<UserEntity> = query.selectFrom(userQEM)
            .where(userQEM.email.eq(username))
            .fetch()
        return userEntity
    }

    fun isExist(email:String) : Long {
        val userQEM = QUserEntity.userEntity
        val value = query.selectFrom(userQEM).where(
            userQEM.email.eq(email)
        ).fetchCount()
        return value
    }

}