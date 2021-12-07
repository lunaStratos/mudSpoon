package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 짤방 Controller
 * 짤방 게시판 담당
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-07 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@RestController()
@RequestMapping("/Zzal")
class ZzalController {

    private val log: Logger = LoggerFactory.getLogger(ZzalController::class.java)

    @Autowired
    private lateinit var naverApi: NaverApi

    @RequestMapping("/board", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun sticker(): String {
        return "zz"
    }

}