package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.TestEntity
import com.lunastratos.mudspoon.Service.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TestService {
    @Autowired
    private val testRepository: TestRepository? = null

    @Transactional
    fun save(testDto: TestEntity) {
        testRepository?.save(testDto)
    }

    fun findByAll():List<TestEntity> {
        return testRepository!!.findAllBy()
    }
}