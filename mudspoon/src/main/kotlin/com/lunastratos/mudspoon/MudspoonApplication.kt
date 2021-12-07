package com.lunastratos.mudspoon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("classpath:/common.properties")
class MudspoonApplication

fun main(args: Array<String>) {
	runApplication<MudspoonApplication>(*args)
}
