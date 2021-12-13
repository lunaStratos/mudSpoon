package com.lunastratos.mudspoon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories


@SpringBootApplication
@PropertySource("classpath:/common.properties")
class MudspoonApplication

fun main(args: Array<String>) {
	runApplication<MudspoonApplication>(*args)
}
