package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.TestEntity
import com.lunastratos.mudspoon.Entity.UserEntity
import com.lunastratos.mudspoon.Repository.QUserRepository
import com.lunastratos.mudspoon.Repository.TestRepository
import com.lunastratos.mudspoon.Repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService @Autowired constructor (
    private val qUserRepo: QUserRepository,
    private val userRepo: UserRepository,
){

    /**
     * 이메일로 유저조회
     *
     * @param username String
     * */
    fun selectUserByEmail(email:String):List<UserEntity> {
        return qUserRepo.selectUserByEmail(email)
    }

    /**
     * 유저 존재여부
     *
     * @param email String
     * */
    fun isExist(email:String):Long {
        return qUserRepo.isExist(email)
    }

    /**
     * 회원가입
     *
     * @param userEntity Object
     * */
    fun save(userEntity: UserEntity){
        userRepo.save(userEntity)
    }
}