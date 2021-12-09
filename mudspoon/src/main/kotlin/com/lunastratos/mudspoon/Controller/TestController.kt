package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import com.lunastratos.mudspoon.Service.TestService
import com.lunastratos.mudspoon.Repository.QTestRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class TestController {

    private val log: Logger = LoggerFactory.getLogger(TestController::class.java)

    @Autowired
    private lateinit var testService: TestService
    @Autowired
    private lateinit var qTestService: QTestRepository

    @Autowired
    private lateinit var naverApi: NaverApi

    @RequestMapping("/testmain", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun main(): String {
        return "main"
    }

    @RequestMapping("/testdb", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun Dbtest(): String {
        val allData = testService.findByAll()
        val allData2 = qTestService.selectAllTestEntity()
        println(allData2)
        var value = ""
        allData.map {
            value += " / " + it.testStr + " / " +it.testInt
        }
        return value
    }


}