package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.RefreshTokenEntity
import com.lunastratos.mudspoon.Repository.RefreshTokenRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.time.Duration


@Service
class RedisService @Autowired constructor(
    private val refeshRepo: RefreshTokenRepository,
    private val stringRedisTemplate: StringRedisTemplate
){
    @Value("\${mudSpoon.refresh_token_time_s}")
    private lateinit var refeshTokenValidTime :String

    fun save(accessToken:String, refreshToken :String){
        val refreshTokenValue = RefreshTokenEntity(refreshToken, refreshToken)
        refeshRepo.save(refreshTokenValue)

    }


    fun getData(key: String?): String? {
        val valueOperations = stringRedisTemplate!!.opsForValue()
        return valueOperations[key!!]
    }

    fun setData(key: String, value: String) {
        val valueOperations = stringRedisTemplate!!.opsForValue()
        valueOperations[key] = value
    }

    fun setDataExpire(key: String, value: String, duration: Long) {
        val valueOperations = stringRedisTemplate!!.opsForValue()
        val expireDuration: Duration = Duration.ofSeconds(duration)
        valueOperations.set(key, value, expireDuration)
    }

    //시간 지정됨
    fun setDataExpired(key: String, value: String) {
        val valueOperations = stringRedisTemplate!!.opsForValue()
        val expireDuration: Duration = Duration.ofSeconds(refeshTokenValidTime.toLong())
        valueOperations.set(key, value, expireDuration)
    }

    fun deleteData(key: String) {
        stringRedisTemplate!!.delete(key)
    }
}