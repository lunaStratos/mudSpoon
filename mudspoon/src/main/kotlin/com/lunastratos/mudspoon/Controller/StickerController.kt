package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 흙수저프랜드 스티커 Controller
 * 스티커 게시판 담당
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-07 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@RestController
class StickerController {

    private val log: Logger = LoggerFactory.getLogger(StickerController::class.java)

    @Autowired
    private lateinit var naverApi: NaverApi

    @RequestMapping("/sticker", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun sticker(): String {
        return "sticker"
    }

}