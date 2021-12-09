package com.lunastratos.mudspoon

import com.lunastratos.mudspoon.Entity.RefreshTokenEntity
import com.lunastratos.mudspoon.Repository.RefreshTokenRepository
import com.lunastratos.mudspoon.Repository.TestRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.persistence.EntityManager


@SpringBootTest
class MudspoonApplicationTests @Autowired constructor(

	val testRepo: TestRepository,
	val entityManager: EntityManager,
	val query: JPAQueryFactory,
	var refRepo: RefreshTokenRepository

) {


	@Test
	fun contextLoads() {
	}

	@Test
	fun redisConnectionTest() {
		val ref = RefreshTokenEntity("1", "2")
		refRepo.save(ref)
		val findPerson = refRepo.findById("1")
		println("${findPerson.get().key} ${findPerson.get().value}")


	}


}
