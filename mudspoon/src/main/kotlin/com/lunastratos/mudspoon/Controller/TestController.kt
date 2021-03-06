package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import com.lunastratos.mudspoon.Service.TestService
import com.lunastratos.mudspoon.Repository.QTestRepository
import com.lunastratos.mudspoon.Util.CommonUtil
import org.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/test")
class TestController @Autowired constructor(
    private val testService: TestService,
    private val qTestService: QTestRepository,
    private val naverApi: NaverApi
) {

    private val log: Logger = LoggerFactory.getLogger(TestController::class.java)

    @RequestMapping("/", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun main(
        @RequestBody payLoad: String
    ): ResponseEntity<*>? {
        var result = CommonUtil().getResultJson()

        try {
            var param = JSONObject(payLoad)
            return ResponseEntity.ok<Any>(result.toString())
        }catch (e:Exception){

            result.put("status", 9000)
            return ResponseEntity.badRequest().body<Any>(result.toString())
        }
    }



}