package com.lunastratos.mudspoon.Config.Mail

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.*


@Configuration
class MailConfig {

    private val log: Logger = LoggerFactory.getLogger(MailConfig::class.java)

    fun EmailConfig() {
        log.info("EmailConfig.java constructor called")
    }

    @Value("\${spring.mail.transport.protocol}")
    private lateinit var protocol:String

    @Value("\${spring.mail.properties.mail.smtp.auth}")
    private lateinit var  auth:String

    @Value("\${spring.mail.properties.mail.smtp.starttls.enable}")
    private lateinit var  starttls:String

    @Value("\${spring.mail.debug}")
    private lateinit var  debug:String

    @Value("\${spring.mail.host}")
    private lateinit var  host:String

    @Value("\${spring.mail.port}")
    private lateinit var  port:String

    @Value("\${spring.mail.username}")
    private lateinit var  username:String

    @Value("\${spring.mail.password}")
    private lateinit var  password:String

    @Value("\${spring.mail.default.encoding}")
    private lateinit var  encoding:String

    @Bean
    fun javaMailSender(): JavaMailSender? {
        val mailSender = JavaMailSenderImpl()
        val properties = Properties()
        properties.put("mail.transport.protocol", protocol)
        properties.put("mail.smtp.auth", auth)
        properties.put("mail.smtp.starttls.enable", starttls)
        properties.put("mail.smtp.debug", debug)
        mailSender.host = host
        mailSender.username = username
        mailSender.password = password
        mailSender.setPort(Integer.parseInt(port))
        mailSender.javaMailProperties = properties
        mailSender.defaultEncoding = encoding
        return mailSender
    }
}
