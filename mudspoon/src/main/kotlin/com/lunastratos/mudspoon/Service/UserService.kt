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

    fun selectUserByEmail(email:String):List<UserEntity> {
        return qUserRepo.selectUserByEmail(email)
    }

    fun save(userEntity: UserEntity){
        userRepo.save(userEntity)
    }
}