package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Config.Security.JwtTokenProvider
import com.lunastratos.mudspoon.Entity.AuthEntity
import com.lunastratos.mudspoon.Entity.RegisterEntity
import com.lunastratos.mudspoon.Entity.RoleType
import com.lunastratos.mudspoon.Entity.UserEntity
import com.lunastratos.mudspoon.Service.RedisService
import com.lunastratos.mudspoon.Service.UserService
import org.bson.json.JsonObject
import org.json.simple.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/Auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val tokenProvider: JwtTokenProvider,
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder,
    private val redisService: RedisService
) {
    private val log: Logger = LoggerFactory.getLogger(AuthController::class.java)

    //@Throws(Exception::class)
    @PostMapping("/SignIn")
    fun SignIn(@RequestBody authReqModel: AuthEntity): String {
            try {
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


                var json = JSONObject()
                json.put("accessToken", accessToken)
                json.put("refreshToken", refreshToken)
                return json.toJSONString()
            }catch (e:BadCredentialsException){
                return e.message +""
            }

    }

    /** 등록 */
    //@Throws(Exception::class)
    @PostMapping("/Register")
    fun Register(@RequestBody param: RegisterEntity): ResponseEntity<*>? {
        if (!userService.selectUserByEmail(param.email!!).isEmpty()) {
            return ResponseEntity
                .badRequest()
                .body<Any>("Error: Email is already in use!")
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

        userService.save(createUser)

        return ResponseEntity.ok<Any>("User registered successfully!")
    }

    /**
     * 확인 테스트
     * */
    @PostMapping("/info")
    fun getInfo(@RequestHeader(value = "Authorization") authorization: String ): String {
        println(authorization)
        val token = tokenProvider.resolveTokenInfo(authorization)
        val details = tokenProvider.getUserId(token)
        println(details)
        return ""


    }

    /**
     * 확인 테스트
     * */
    @PostMapping("/RefreshToken")
    fun RefreshToken(@RequestHeader(value = "Authorization") authorization: String,
                     @RequestHeader(value = "Refresh-Token") refresh: String): String {

        val accessToken = tokenProvider.resolveTokenInfo(authorization)
        val refreshToken = refresh

        // 엑세스 토큰으로 검사
        val getTokenEmail = tokenProvider.getUserId(accessToken)
        val getTokenLife = tokenProvider.validateToken(accessToken)
        println(getTokenEmail)
        println(getTokenLife)

        //이메일로 리플레시 토큰 얻어오기
        val redisRefreshToken = redisService.getData(getTokenEmail)!!

        //토큰이 살아있는가?
        if(getTokenLife){
            return "엑세스토큰 안죽음"
        }

        //리플레시토큰이 없는가?
        if(redisRefreshToken.isEmpty()){
            return "님토큰없음"
        }

        //리플레시토큰이 같지 않은가?
        if(!redisRefreshToken.equals(refreshToken)){
            return "토큰이 안같은데?"
        }


        //RefreshToken 생성후 저장
        val newRefreshToken = tokenProvider.createRefreshToken()
        val newAccessToken = tokenProvider.createToken(getTokenEmail)
        redisService.setDataExpired(getTokenEmail, newRefreshToken)

        return ""


    }


    /**
     * 확인 테스트
     * */
    @PostMapping("/Logout")
    fun Logout(@RequestHeader(value = "Authorization") authorization: String ): String {
        println(authorization)
        val token = tokenProvider.resolveTokenInfo(authorization)
        val details = tokenProvider.getUserId(token)
        println(details)
        return ""


    }



}