package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import com.lunastratos.mudspoon.Entity.LoungeEntity
import com.lunastratos.mudspoon.Service.LoungeService
import com.lunastratos.mudspoon.Util.BoardPaging
import com.lunastratos.mudspoon.Util.CommonUtil
import org.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * 라운지 Controller
 * 라운지 게시판 담당
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-07 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@RestController
@RequestMapping("/lounge")
class LoungeController @Autowired constructor(
    private val loungeService: LoungeService,
    private val naverApi: NaverApi
    ){

    private val log: Logger = LoggerFactory.getLogger(LoungeController::class.java)


    /**
     * List - 리스트
     * desc: search가 있을 경우 검색 작동
     * @param page Int
     * @param search String
     * */
    @RequestMapping("/list/{page}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun list(
        @PathVariable("page",  required = true) page: String,
        @RequestParam("search",  required = true, defaultValue = "") search: String
    ): ResponseEntity<*>? {
        var result = CommonUtil().getResultJson()

        try {

            println("${page} ${search}")

            val allCount = loungeService.allCount()
            val startEndData = BoardPaging(allCount, page.toInt())
            val startPage = startEndData.startPage

            var endPage = startEndData.endPage
            var boardList = {}

            val getBoardList = loungeService.selectBoardList(startPage.toLong(), search)
            result.put("list", getBoardList)
            result.put("startPage", startPage)
            result.put("endPage", endPage)

            return ResponseEntity.ok<Any>(result.toString())
        }catch (e:Exception){
            result.put("status", 9000)
            return ResponseEntity.badRequest()
                .body<Any>(result.toString())
        }

    }

    /**
     * write - 글쓰기
     * desc:
     * @param
     * */
    @RequestMapping("/write", method = arrayOf(RequestMethod.POST), produces = arrayOf("application/json"))
    @ResponseBody
    fun write(
        @RequestBody payLoad: String
    ): ResponseEntity<*>? {

        var result = CommonUtil().getResultJson()

        try {

        var param = JSONObject(payLoad)
        val contents = param.get("contents") as String
        println("contents ${contents}")

        var loungeEntity = LoungeEntity()
        loungeEntity.auther = "asdf"
        loungeEntity.contents = contents
        loungeEntity.id = 23

        loungeService.save(loungeEntity)

        var result = CommonUtil().getResultJson()

        return ResponseEntity.ok<Any>(result.toString())

        }catch (e:Exception){
            result.put("status", 9000)
            return ResponseEntity.badRequest()
                .body<Any>(result.toString())

        }
    }

}