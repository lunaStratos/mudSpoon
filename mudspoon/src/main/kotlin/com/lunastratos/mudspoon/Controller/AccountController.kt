package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import org.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 로그인 Controller
 * 네이버, 카카오, 페이스북 등의 로그인과 회원등록 담당
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-07 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@RestController
@RequestMapping("/Account")
class AccountController {

    private val log: Logger = LoggerFactory.getLogger(AccountController::class.java)

    @Autowired
    private lateinit var naverApi: NaverApi



    /**
     * 네이버 로그인 창 : 나중에 프론트로 뺌.
     * @param
     * @return
     * */
    @RequestMapping("/registerBtnNaver", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun registerBtnNaver(): String {
        val allData = naverApi.getSocialLoginAutherize()
        var value =  allData.toString()
        log.info(value)
        return value
    }

    /**
     * 네이버 로그인 callback
     * @param
     * @return
     * */
    @RequestMapping("/registerBtnNaverCallback", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun registerBtnNaverCallback(@RequestParam(value = "code") code : String,
                                 @RequestParam(value = "state") state : String): String {

        val getToken = naverApi.getSocialLoginToken(code, state)
        val getTokenJson : JSONObject = JSONObject(getToken)

        val access_token = getTokenJson.getString("access_token")
        val refresh_token = getTokenJson.getString("refresh_token")
        val expires_in = getTokenJson.getString("expires_in")

        var value = naverApi.getSocialLoginMeInfo(access_token)
        log.info(value.toString())


        return value.toString()
    }
}