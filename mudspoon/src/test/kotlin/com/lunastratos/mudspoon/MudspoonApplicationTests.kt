package com.lunastratos.mudspoon

import com.lunastratos.mudspoon.Entity.QUserEntity
import com.lunastratos.mudspoon.Entity.UserEntity
import com.lunastratos.mudspoon.Repository.TestRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.persistence.EntityManager

@SpringBootTest
class MudspoonApplicationTests @Autowired constructor(

	val testRepo: TestRepository,
	val entityManager: EntityManager,
	val query: JPAQueryFactory
) {

	@Test
	fun testCount() {
		// when
		val count = testRepo.count()

		// then
		Assertions.assertThat(count).isEqualTo(0)
	}

	@Test
	fun testFindByAll() {
		// when
		val all = testRepo.findAllBy()

		// then
		println(all)
	}

	@Test
	fun testFindByID() {
		val userQEM = QUserEntity.userEntity
		val userEntity : List<UserEntity> = query.selectFrom(userQEM)
			.where(userQEM.email.eq("test@test.com"), userQEM.password.eq("test"))
			.fetch()

		// then
		println(userEntity)
	}


}
