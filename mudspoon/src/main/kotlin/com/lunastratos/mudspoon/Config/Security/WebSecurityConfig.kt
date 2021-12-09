package com.lunastratos.mudspoon.Config.Security

import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


/**
 * https://deeplify.dev/back-end/spring/configure-spring-security-rest-api
 * https://github.com/HomoEfficio/dev-tips/blob/master/Spring%20Security%EC%9D%98%20%EC%82%AC%EC%9A%A9%EC%9E%90%20%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8%20%EA%B2%80%EC%82%AC.md
 * */
@EnableWebSecurity
class WebSecurityConfig(
    val jwtTokenProvider: JwtTokenProvider,
    val customUserDetailService : CustomUserDetailService,
    ) : WebSecurityConfigurerAdapter(){



    // 암호화에 필요한 PasswordEncoder 를 Bean 등록합니다.
    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

    // authenticationManager를 Bean 등록합니다
    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    override fun configure(http: HttpSecurity?) {
        if (http != null) {
            http.cors()
                .and()
                    .httpBasic().disable() // Rest API 형태로 개발하기 때문에 비활성
                    .csrf().disable() // csrf 보안 토큰 disable처리.
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 인증이므로 세션 역시
                .and()
                    .exceptionHandling()    // 에러 예외 처리
                    .authenticationEntryPoint(RestAuthenticationEntryPoint())
                .and()
                    .authorizeRequests()
                    .antMatchers("api/Account/My/**").hasRole("USER") // 프로필 부분 체크
                    .anyRequest().permitAll()               // 나머지 요청 ok
                .and()
                    .addFilterBefore(JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter::class.java )
        }
    }

    @Bean
    fun authenticationProvider(): AuthenticationProvider? {
        return CustomAuthenticationProvider(customUserDetailService)
    }


    // 인증의 저장 관리를 해줄 userDetailsService, passwordEncoder와 함께 등록해줍니다.
    override fun configure(auth: AuthenticationManagerBuilder?) {
        //auth!!.userDetailsService<UserDetailsService>(customUserDetailService).passwordEncoder(passwordEncoder())
        auth!!.authenticationProvider(authenticationProvider());

    }


}