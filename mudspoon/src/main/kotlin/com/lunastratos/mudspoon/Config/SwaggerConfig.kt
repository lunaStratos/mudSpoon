package com.lunastratos.mudspoon.Config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * SwaggerConfig
 * desc: Swagger 설정
 *
 * History:
 *    LunaStratos, 1.0, 2022-02-11 초기작성
 *
 * @date        2022-02-11
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun apiV1(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .groupName("groupName1")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.lunastratos.mudspoon.Controller"))
            .paths(PathSelectors.any()).build()
    }

    @Bean
    fun apiV2(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .useDefaultResponseMessages(false)
            .groupName("groupName2")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.lunastratos.mudspoon.Controller"))
            .paths(PathSelectors.any()).build()
    }
}