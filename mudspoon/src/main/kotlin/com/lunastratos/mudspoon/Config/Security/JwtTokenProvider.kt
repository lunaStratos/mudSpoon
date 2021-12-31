package com.lunastratos.mudspoon.Config.Security

import io.jsonwebtoken.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest

/**
 * JwtTokenProvider
 * desc: Spring security - JWT 토큰 관리
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-15 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@Component
class JwtTokenProvider(
    private val userDetailsService: CustomUserDetailService
) {

    private val log: Logger = LoggerFactory.getLogger(JwtTokenProvider::class.java)


    @Value("\${mudSpoon.client_secret}")
    private lateinit var secretKey :String

    @Value("\${mudSpoon.access_token_time}")
    private lateinit var accessTokenValidTime :String

    @Value("\${mudSpoon.refresh_token_time}")
    private lateinit var refreshTokenValidTime:String

    // 비밀키를 Base64로 인코딩해 주었습니다.
    @PostConstruct
    protected fun init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())
    }

    fun createRefreshToken() :String{
        val now = Date()
        return Jwts.builder()
            .setIssuedAt(now)
            .setExpiration(Date(now.time + accessTokenValidTime.toLong()))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact()
    }

    // 토큰 만들기
    fun createToken(email: String?): String =
        Jwts.builder().let {
            val now = Date()

            // 전달받은 인증 정보로부터 principal 값을 가져옵니다.
            //val userPrincipal = authentication?.principal as UserPrincipal
            //val userPrincipal = authentication as CustomAuthenticationToken

            // 토큰 빌더를 통해서 토큰을 생성해줍니다.
            it.setClaims(
                // username = id 입니다.(PK)
                Jwts.claims().setSubject(email)
            )
                .setIssuedAt(now)
                .setExpiration(Date(now.time + refreshTokenValidTime.toLong()))
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, secretKey)
                .compact()
        }!!

    // Authentication 객체 가져오기
    fun getAuthentication(token: String?): Authentication =
        userDetailsService.loadUserByUsername(this.getUserId(token)).let {
            UsernamePasswordAuthenticationToken(it, it.password, it.authorities)
        }

    // 사용자 Id 가져오기
    fun getUserId(token: String?): String =
        Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token)
            .body
            .subject

    // 요청으로부터 토큰 가져오기
    fun resolveToken(req: HttpServletRequest) =
        req.getHeader("Authorization")?.let {
            when (it.startsWith("Bearer ")) {
                true -> it.substring(7, it.length)
                false -> null
            }
        }

    // 요청으로부터 토큰 가져오기
    fun resolveTokenInfo(auth: String) :String{
        when (auth.startsWith("Bearer ")) {
            true -> return auth.substring(7, auth.length)
            false -> return "null"
        }
    }


    // 토큰 유효성 검사
    fun validateToken(jwtToken: String?): Boolean {
        return try {
            Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwtToken)
                .let { !it.body.expiration.before(Date()) }
        } catch ( ex : SignatureException) {
            log.error("Invalid JWT signature")
            return false
        } catch ( ex : MalformedJwtException) {
            log.error("Invalid JWT token")
            return false
        } catch ( ex: ExpiredJwtException) {
            log.error("Expired JWT token")
            return false
        } catch ( ex: UnsupportedJwtException) {
            log.error("Unsupported JWT token")
            return false
        } catch ( ex: IllegalArgumentException) {
            log.error("JWT claims string is empty.")
            return false
        }
    }

}