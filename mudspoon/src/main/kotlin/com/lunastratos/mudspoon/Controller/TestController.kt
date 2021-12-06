package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Repository.TestService
import com.lunastratos.mudspoon.Service.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class TestController {

    @Autowired
    private lateinit var testService: TestService


    @RequestMapping("/test", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun test(): String {
        return "test"
    }

    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun main(): String {
        return "main"
    }

    @RequestMapping("/dbtest", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun Dbtest(): String {
        val allData = testService.findByAll()
        var value = ""
        allData.map {
            value += " / " + it.testStr + " / " +it.testInt
        }
        return value
    }
}