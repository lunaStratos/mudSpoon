package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.TestEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : JpaRepository<TestEntity?, Long?>{
    fun findAllBy(): List<TestEntity>

}