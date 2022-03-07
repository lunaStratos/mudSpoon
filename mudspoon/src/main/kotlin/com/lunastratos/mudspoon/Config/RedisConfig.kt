package com.lunastratos.mudspoon.Config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

/**
 * RedisConfig
 * desc: Redis config 모듈
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-19 초기작성
 *
 * @date        2021-12-19
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@Configuration
@EnableRedisRepositories
class RedisConfig {

    @Bean
    fun redisConnectionFactory(): LettuceConnectionFactory? {
        return LettuceConnectionFactory("redis-14146.c10.us-east-1-2.ec2.cloud.redislabs.com", 14146)
    }

    @Bean
    fun redisTemplate(): RedisTemplate<*, *>? {
        val redisTemplate = RedisTemplate<ByteArray, ByteArray>()
        redisTemplate.setConnectionFactory(redisConnectionFactory()!!)
        return redisTemplate
    }
}