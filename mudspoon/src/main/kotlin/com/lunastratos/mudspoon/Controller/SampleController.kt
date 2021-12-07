package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 샘플 Controller
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-07 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */


@RestController
class SampleController {

    private val log: Logger = LoggerFactory.getLogger(SampleController::class.java)

    @Autowired
    private lateinit var naverApi: NaverApi

    @RequestMapping("/test", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun test(): String {
        return "test"
    }

}