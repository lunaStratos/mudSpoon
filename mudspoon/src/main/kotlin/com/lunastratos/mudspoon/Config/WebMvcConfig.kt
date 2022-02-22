package com.lunastratos.mudspoon.Config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * WebMvcConfig
 * desc: WebMvcConfigurer - Xss 방어 코드
 *
 * History:
 *    LunaStratos, 1.0, 2022-02-22 초기작성
 *
 * @date        2022-02-22
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@Configuration
class WebMvcConfig : WebMvcConfigurer {

    @Bean
    fun jsonEscapeConverter(): MappingJackson2HttpMessageConverter {
        // MappingJackson2HttpMessageConverter Default ObjectMapper 설정 및 ObjectMapper Config 설정
        val objectMapper = Jackson2ObjectMapperBuilder.json().build<ObjectMapper>()
        objectMapper.factory.characterEscapes = HTMLCharacterEscapesConfig()
        return MappingJackson2HttpMessageConverter(objectMapper)
    }
}