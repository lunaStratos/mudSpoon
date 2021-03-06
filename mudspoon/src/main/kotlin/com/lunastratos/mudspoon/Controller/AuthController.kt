package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import com.lunastratos.mudspoon.Config.Security.JwtTokenProvider
import com.lunastratos.mudspoon.Vo.AuthEntity
import com.lunastratos.mudspoon.Entity.RegisterEntity
import com.lunastratos.mudspoon.Entity.RoleType
import com.lunastratos.mudspoon.Entity.UserEntity
import com.lunastratos.mudspoon.Service.RedisService
import com.lunastratos.mudspoon.Service.UserService
import com.lunastratos.mudspoon.Util.CommonUtil
import org.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

/**
 * 계점 담당 Controller
 *
 * History:
 *    LunaStratos, 1.0, 2022-01-09 초기작성
 *
 * @date        2022-01-09
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@RestController
@RequestMapping("/account")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val tokenProvider: JwtTokenProvider,
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder,
    private val redisService: RedisService,
    private val naverApi: NaverApi

) {
    private val log: Logger = LoggerFactory.getLogger(AuthController::class.java)

    /**
     * 로그인
     * desc: 로그인 post 시 작동
     * */
    @PostMapping("/login")
    fun SignIn(@RequestBody authReqModel: AuthEntity): ResponseEntity<*>? {
        var result = CommonUtil().getResultJson()

        val email = authReqModel.email
        val prin = UsernamePasswordAuthenticationToken(
            email,
            authReqModel.password
        )
        println("prin ${prin}")

        val authentication = authenticationManager.authenticate(
            prin
        )
        println("authentication ${authentication}")

        // 인증이 완료되면, 인증 객체를 저장해줍니다.
        // 토큰을 만들어서 리턴하여 줍니다.
        SecurityContextHolder.getContext().authentication = authentication

        val accessToken = tokenProvider.createToken(email)
        //RefreshToken 생성
        val refreshToken = tokenProvider.createRefreshToken()

        redisService.setDataExpired(email, refreshToken)

        result.put("accessToken", accessToken)
        result.put("refreshToken", refreshToken)

        return ResponseEntity.ok<Any>(result.toString())



    }

    /**
     * 회원가입
     * desc: post, 등록시작동
     * */
    @PostMapping("/register")
    fun Register(@RequestBody param: RegisterEntity): ResponseEntity<*>? {
        var result = CommonUtil().getResultJson()

        if (!userService.selectUserByEmail(param.email!!).isEmpty()) {
            result.put("status", 9000)
            return ResponseEntity
                .badRequest()
                .body<Any>(result.toString())
        }

        val isExist =  userService.isExist(param.email)

        // 이미 존재하는 아이디
        if(isExist > 0){
            result.put("status", 2000)
            return ResponseEntity.ok<Any>(result.toString())
        }

        val createUser = UserEntity(
            null,
            param.email,
            passwordEncoder.encode(param.password),
            param.name,
            RoleType.ROLE_USER,
            null,
            null
        )

        // 회원가입
        userService.save(createUser)

        return ResponseEntity.ok<Any>(result.toString())


    }

    /**
     * 회원가입시 이미 가입된 아이디 체크
     * */
    @PostMapping("/register/isExsit")
    fun isExist(@RequestBody email: String): ResponseEntity<*>? {

        var result = CommonUtil().getResultJson()


        val isExist =  userService.isExist(email)

        // 이미 존재하는 아이디
        if(isExist > 0){
            result.put("status", 2000)
            return ResponseEntity.ok<Any>(result.toString())
        }

        return ResponseEntity.ok<Any>(result.toString())

    }


    /**
     * 상태 확인 테스트
     * 맞는지 아닌지 보는 기능
     * */
    @PostMapping("/tokenCheck")
    fun getInfo(@RequestHeader(value = "Authorization") authorization: String ): ResponseEntity<*>? {

        var result = CommonUtil().getResultJson()
        println(authorization)

        val token = tokenProvider.resolveTokenInfo(authorization)
        val details = tokenProvider.getUserId(token)
        println(details)
        return ResponseEntity.ok<Any>(result.toString())

    }

    /**
     * 리플레시 토큰
     * */
    @PostMapping("/refreshToken")
    fun refreshToken(@RequestHeader(value = "Authorization") authorization: String,
                     @RequestHeader(value = "RefreshToken") refresh: String): ResponseEntity<*>? {
        val result = CommonUtil().getResultJson()

        println("authorization ${authorization}")
        println("refresh ${refresh}")

        val accessToken = tokenProvider.resolveTokenInfo(authorization)
        val refreshToken = tokenProvider.resolveTokenInfo(refresh)

        // 엑세스 토큰으로 검사
        val getTokenEmail = tokenProvider.getUserId(accessToken)
        val getTokenLife = tokenProvider.validateToken(accessToken)

        println(getTokenEmail)
        println(getTokenLife)

        //이메일로 리플레시 토큰 얻어오기
        val redisRefreshToken = redisService.getData(getTokenEmail)!!
        println("redisRefreshToken ${redisRefreshToken} ${redisRefreshToken.equals(refreshToken)}")

        //토큰이 살아있는가? => 정상로그인
        if(getTokenLife){
            return ResponseEntity.ok<Any>(result.toString())
        }

        //리플레시토큰이 없는가? => 재로그인
        if(redisRefreshToken.isEmpty()){
            result.put("status", 5000)
            return ResponseEntity.ok<Any>(result.toString())
        }

        //리플레시토큰이 같지 않은가? => 재로그인
        if(!redisRefreshToken.equals(refreshToken)){
            result.put("status", 5000)
            return ResponseEntity.ok<Any>(result.toString())
        }

        //RefreshToken 생성후 Redis에 저장
        val newRefreshToken = tokenProvider.createRefreshToken()
        val newAccessToken = tokenProvider.createToken(getTokenEmail)
        redisService.setDataExpired(getTokenEmail, newRefreshToken)

        result.put("status" , 1010) // 재갱신
        result.put("accessToken" , newAccessToken)
        result.put("refreshToken" , newRefreshToken)

        return ResponseEntity.ok<Any>(result.toString())

    }


    /**
     * [로그아웃]
     * 토큰 삭제
     * */
    @PostMapping("/logout")
    fun Logout(@RequestHeader(value = "Authorization") authorization: String ): ResponseEntity<*>? {
        val result = CommonUtil().getResultJson()

        println(authorization)
        val token = tokenProvider.resolveTokenInfo(authorization)
        val details = tokenProvider.getUserId(token)
        println(details)
        return ResponseEntity.ok<Any>(result.toString())

    }


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