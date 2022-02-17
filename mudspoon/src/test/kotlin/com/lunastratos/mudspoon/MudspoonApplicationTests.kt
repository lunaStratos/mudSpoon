package com.lunastratos.mudspoon

import com.lunastratos.mudspoon.Repository.OrderRepository
import com.lunastratos.mudspoon.Repository.QStickerRepository
import com.lunastratos.mudspoon.Service.RedisService
import com.lunastratos.mudspoon.Util.Example.ProtoTypeSample
import com.lunastratos.mudspoon.Util.Example.SingleTonSample
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import java.time.Duration


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
	val ctx : ApplicationContext,
	val redisService: RedisService,
	val orderRepository : OrderRepository,
	val qStickerRepository: QStickerRepository
) {


	/**
	 * 싱글톤 프로토타입 테스트
	 * */
	@Test
	fun singletonTest() {
		println("singletonTest")

		println(ctx.getBean(singleTonSample.javaClass))
		println(ctx.getBean(singleTonSample.javaClass))
		println(ctx.getBean(singleTonSample.javaClass))

		println(ctx.getBean(protoTypeSample.javaClass))
		println(ctx.getBean(protoTypeSample.javaClass))
		println(ctx.getBean(protoTypeSample.javaClass))

	}


	@Test
	fun jpa1problem(){
		println("jpa1problem")
		val members = orderRepository.findAll()
		print(members)
	}

	//JPA N+1 문제
	@Test
	fun jpa1problemSticker(){
		println("jpa1problemSticker Solve")
		val members = qStickerRepository.findAll()
		print(members)
	}

	//JPA N+1 해결법 fetchJoin
	@Test
	fun jpa1problemStickerSolve(){
		println("jpa1problemStickerSolve Solve")
		val members = qStickerRepository.findAllSolve()
		print(members)
	}


	@Test
	fun redisConnectionTest() {
		val expireDuration: Duration = Duration.ofSeconds(10)
		redisService.setDataExpire("test1", "111", 10)
	}
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
