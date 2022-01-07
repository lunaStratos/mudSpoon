package com.lunastratos.mudspoon.Config.Security

import com.lunastratos.mudspoon.Controller.StickerController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.servlet.http.HttpServletResponse
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import org.springframework.security.web.AuthenticationEntryPoint
import kotlin.jvm.Throws
import org.springframework.security.core.AuthenticationException

/**
 * Spring security에서 Exception이 발생했을 때, 처리해줄 클래스인 RestAuthenticationEntryPoint를 정의
 * */
class RestAuthenticationEntryPoint : AuthenticationEntryPoint {


    private val log: Logger = LoggerFactory.getLogger(RestAuthenticationEntryPoint::class.java)

    @Throws(IOException::class, ServletException::class)
    override fun commence(
        httpServletRequest: HttpServletRequest,
        httpServletResponse: HttpServletResponse,
        e: AuthenticationException
    ) {
        e.printStackTrace()
        log.error("Responding with unauthorized error. Message - {}", e.message)
        httpServletResponse.sendError(
            HttpServletResponse.SC_UNAUTHORIZED,
            e.localizedMessage
        )
    }

}