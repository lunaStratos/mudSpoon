package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.TestEntity
import com.lunastratos.mudspoon.Repository.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TestService  @Autowired constructor(
    private val testRepository: TestRepository
){

    @Transactional
    fun save(testDto: TestEntity) {
        testRepository?.save(testDto)
    }

    fun findByAll():List<TestEntity> {
        return testRepository!!.findAllBy()
    }
}