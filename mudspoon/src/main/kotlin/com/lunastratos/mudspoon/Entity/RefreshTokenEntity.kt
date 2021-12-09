package com.lunastratos.mudspoon.Entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash


@RedisHash(value = "refreshToken", timeToLive = 1800)
class RefreshTokenEntity (

    @Id
    var key: String,
    var value: String
    )