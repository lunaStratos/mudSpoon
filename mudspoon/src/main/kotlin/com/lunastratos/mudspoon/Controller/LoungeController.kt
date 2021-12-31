package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import com.lunastratos.mudspoon.Entity.LoungeEntity
import com.lunastratos.mudspoon.Service.LoungeService
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
    private val loungeService: LoungeService
    ){

    private val log: Logger = LoggerFactory.getLogger(LoungeController::class.java)

    @Autowired
    private lateinit var naverApi: NaverApi

    /**
     * List - 리스트
     * desc: 페이지가 있을 경우
     * @param page Int
     * @param title String
     * */
    @RequestMapping("/list/{page}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun list(
        @PathVariable("page",  required = true) page: String,
        @RequestParam("search",  required = true, defaultValue = "") search: String
    ): ResponseEntity<*>? {

        println("${page} ${search}")
        var startPage = 1
        var endPage = 1
        var boardList = {}

        val getBoardList = loungeService.selectBoardList(page.toInt(), search)
        var result = CommonUtil().getResultJson()
        result.put("list", getBoardList)

        return ResponseEntity.ok<Any>(result.toString())
    }

    /**
     * write - 글쓰기
     *
     * @param
     * */
    @RequestMapping("/write", method = arrayOf(RequestMethod.POST), produces = arrayOf("application/json"))
    @ResponseBody
    fun write(
        @RequestBody payLoad: String
    ): ResponseEntity<*>? {
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
    }

}