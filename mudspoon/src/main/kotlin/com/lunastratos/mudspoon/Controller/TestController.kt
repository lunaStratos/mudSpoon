package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.NaverApi
import com.lunastratos.mudspoon.Repository.TestService
import org.json.JSONObject
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
    private lateinit var naverApi: NaverApi

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

    @RequestMapping("/registerBtnNaver", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun registerBtnNaver(): String {
        val allData = naverApi.getSocialLoginAutherize()
        var value =  allData.toString()
        log.info(value)
        return value
    }

    @RequestMapping("/registerBtnNaverCallback", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun registerBtnNaverCallback(@RequestParam(value = "code") code : String,
                                @RequestParam(value = "state") state : String): String {

        val getToken = naverApi.getSocialLoginToken(code, state)
        val getTokenJson :JSONObject = JSONObject(getToken)

        val access_token = getTokenJson.getString("access_token")
        val refresh_token = getTokenJson.getString("refresh_token")
        val expires_in = getTokenJson.getString("expires_in")

        var value = naverApi.getSocialLoginMeInfo(access_token)
        log.info(value.toString())


        return value.toString()
    }
}