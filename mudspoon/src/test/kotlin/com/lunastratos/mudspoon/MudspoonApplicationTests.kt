package com.lunastratos.mudspoon

import com.lunastratos.mudspoon.Repository.UserRepository
import com.lunastratos.mudspoon.Service.UserService
import com.lunastratos.mudspoon.Util.Example.ProtoTypeSample
import com.lunastratos.mudspoon.Util.Example.SingleTonSample
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext


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
	val singleTonSample : SingleTonSample,
	val protoTypeSample : ProtoTypeSample,
	val ctx : ApplicationContext

) {


	@Test
	fun singletonTest() {
		println(ctx.getBean(singleTonSample.javaClass))
		println(ctx.getBean(singleTonSample.javaClass))
		println(ctx.getBean(singleTonSample.javaClass))

		println(ctx.getBean(protoTypeSample.javaClass))
		println(ctx.getBean(protoTypeSample.javaClass))
		println(ctx.getBean(protoTypeSample.javaClass))

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
