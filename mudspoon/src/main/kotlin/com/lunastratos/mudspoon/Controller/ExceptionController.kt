package com.lunastratos.mudspoon.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.lunastratos.mudspoon.Vo.Status
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

// 전역 에러처리
@ControllerAdvice
class ExceptionController {

    private val log: Logger = LoggerFactory.getLogger(ExceptionController::class.java)

    //400에러
    @ExceptionHandler(RuntimeException::class)
    fun BadRequestException(ex: RuntimeException): ResponseEntity<Any?>? {
        log.warn("error", ex)
        val objectMapper = ObjectMapper()

        val status = Status()
        status.code = "4000"
        status.status = "400"
        status.message = "400 error"

        val setStatus = objectMapper.writeValueAsString(status)

        return ResponseEntity.badRequest().body(setStatus)
    }

    // 401 에러
    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(ex: AccessDeniedException): ResponseEntity<*>? {
        log.warn("error", ex)

        val status = Status()
        status.code = "4001"
        status.status = "401"
        status.message = "401 error"

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.message)
    }

    // 500에러
    @ExceptionHandler(Exception::class)
    fun handleAll(ex: Exception): ResponseEntity<Any?>? {
        log.error("error", ex)
        log.error("Class.name", ex.javaClass.name)

        val errClsssName = ex.javaClass.name
        val status = Status()
        status.code = "5000"
        status.status = "500"
        status.message = errClsssName

        return ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
    }


}