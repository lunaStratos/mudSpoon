package com.lunastratos.mudspoon.Config.Security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

/**
 * AuthenticationProvider
 * desc: Spring security - DB 접속해서 인증 담당
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-15 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@Component
class CustomAuthenticationProvider(
    private val userDetailsService: CustomUserDetailService,

    ): AuthenticationProvider {

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    override fun authenticate(authentication: Authentication?): Authentication {
        val email = authentication!!.principal as String
        val userPw = authentication!!.credentials as String

        val userDetails: UserDetails = userDetailsService.loadUserByUsername(email)


        if (!passwordEncoder.matches(userPw,  userDetails.password.replace("{noop}", ""))) {
            throw BadCredentialsException("BadCredentialsException")
        }

        return CustomAuthenticationToken(email, userPw, userDetails.authorities)
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return true
    }

}