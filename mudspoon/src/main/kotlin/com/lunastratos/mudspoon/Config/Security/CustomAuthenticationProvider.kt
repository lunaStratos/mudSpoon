package com.lunastratos.mudspoon.Config.Security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

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