package com.lunastratos.mudspoon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

//(exclude = [DataSourceAutoConfiguration::class])
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@PropertySource("classpath:/common.properties")
class MudspoonApplication

fun main(args: Array<String>) {
	runApplication<MudspoonApplication>(*args)
}
