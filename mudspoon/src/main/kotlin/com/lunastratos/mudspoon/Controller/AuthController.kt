package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Config.Security.JwtTokenProvider
import com.lunastratos.mudspoon.Entity.AuthEntity
import com.lunastratos.mudspoon.Entity.RegisterEntity
import com.lunastratos.mudspoon.Entity.RoleType
import com.lunastratos.mudspoon.Entity.UserEntity
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
    private val passwordEncoder: PasswordEncoder
) {
    private val log: Logger = LoggerFactory.getLogger(AuthController::class.java)

    //@Throws(Exception::class)
    @PostMapping("/SignIn")
    fun SignIn(@RequestBody authReqModel: AuthEntity): String {
            try {
                val prin = UsernamePasswordAuthenticationToken(
                    authReqModel.email,
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
                val accessToken = tokenProvider.createToken(authentication)
                //RefreshToken 생성
                val refreshToken = tokenProvider.createRefreshToken()

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


}