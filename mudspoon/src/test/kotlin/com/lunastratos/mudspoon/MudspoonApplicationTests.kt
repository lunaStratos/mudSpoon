package com.lunastratos.mudspoon

import com.lunastratos.mudspoon.Entity.MongoDB.LoungeEntity
import com.lunastratos.mudspoon.Entity.RefreshTokenEntity
import com.lunastratos.mudspoon.Repository.LoungeRepository
import com.lunastratos.mudspoon.Repository.RefreshTokenRepository
import com.lunastratos.mudspoon.Repository.TestRepository
import com.lunastratos.mudspoon.Util.BoardPaging
import com.querydsl.jpa.impl.JPAQueryFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import javax.persistence.EntityManager

/**
 * Junit 테스트 모듈
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-19 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@SpringBootTest
class MudspoonApplicationTests @Autowired constructor(

	val testRepo: TestRepository,
	val entityManager: EntityManager,
	val query: JPAQueryFactory,
	var refRepo: RefreshTokenRepository,
	var loungeRepo: LoungeRepository,

) {


	@Test
	fun contextLoads() {


	}

//	@Test
//	fun redisConnectionTest() {
//		val ref = RefreshTokenEntity("1", "2")
//		refRepo.save(ref)
//		val findPerson = refRepo.findById("1")
//		println("${findPerson.get().key} ${findPerson.get().value}")
//
//
//	}
//
//	@Test
//	fun MongoDBConnectionTest() {
//
//		val time = LocalDateTime.now()
//
//		val insertData = LoungeEntity(
//			1,
//			"orion스타",
//			"The quick brown fox jumps over a(the) lazy dog",
//			time,
//			time
//		)
//			"2021-01-01"
//		loungeRepo.save(insertData)
//	}
//
//	@Test
//	fun BoardTest(){
//
//		val total = 123
//		val nowPage = 12
//		val cntPerPage = 10
//
//		var boardPaging: BoardPaging = BoardPaging(total, nowPage)
//
//		val getNowPage = boardPaging.startPage
//		val getEndPage = boardPaging.endPage
//		val getStart = boardPaging.start
//
//		println("${getNowPage} ${getEndPage} ${getStart}")
//
//	}


}
