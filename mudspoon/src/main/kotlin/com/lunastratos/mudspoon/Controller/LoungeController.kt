package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import com.lunastratos.mudspoon.Entity.MongoDB.LoungeEntity
import com.lunastratos.mudspoon.Service.LoungeService
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
@RequestMapping("/Lounge")
class LoungeController @Autowired constructor(
    private val loungeService: LoungeService,
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
    @RequestMapping("/List/{page}/{search}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun List(
        @RequestParam("page",  required = false, defaultValue = "1",) page: Int,
        @RequestParam("title",  required = false, defaultValue = "",) title: String
    ): ResponseEntity<*>? {

        val getBoardList = loungeService.selectBoardList(page, title)

        return ResponseEntity.ok<Any>("User registered successfully!")
    }

    /**
     * write - 글쓰기
     *
     * @param
     * */
    @RequestMapping("/write", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun write(@RequestParam loungeEntity: LoungeEntity): String {

        loungeService.save(loungeEntity)

        return "ok"
    }

}