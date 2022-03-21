package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.QUserEntity
import com.lunastratos.mudspoon.Entity.UserEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class QUserRepository (
    val entityManager: EntityManager,
    val query: JPAQueryFactory
) {

    /**
     * 유저조회 : 테스트용!
     *
     * @param username String
     * */
    fun selectUserByEmailAndPw(username: String): List<UserEntity> {
        val userQEM = QUserEntity.userEntity
        val userEntity : List<UserEntity> = query.selectFrom(userQEM)
            .where(userQEM.email.eq(username), userQEM.password.eq("test"))
            .fetch()
        return userEntity
    }

    /**
     * 이메일로 유저조회
     *
     * @param username String
     * */
    fun selectUserByEmail(username: String): List<UserEntity> {
        val userQEM = QUserEntity.userEntity
        val userEntity : List<UserEntity> = query.selectFrom(userQEM)
            .where(userQEM.email.eq(username))
            .fetch()
        return userEntity
    }

    /**
     * 유저 존재여부
     *
     * @param email String
     * */
    fun isExist(email:String) : Long {
        val userQEM = QUserEntity.userEntity
        val value = query.selectFrom(userQEM).where(
            userQEM.email.eq(email)
        ).fetchCount()
        return value
    }

}