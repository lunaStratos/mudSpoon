package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.TestEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TestRepository : JpaRepository<TestEntity?, Long?>{
    fun findAllBy(): List<TestEntity>

}