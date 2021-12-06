package com.lunastratos.mudspoon

import com.lunastratos.mudspoon.Service.TestRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MudspoonApplicationTests(
	@Autowired
	val testRepo: TestRepository
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

}
