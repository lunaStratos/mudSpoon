package com.lunastratos.mudspoon.Entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name ="t_token")
class RefreshToken (

    @Id
    var key: String,
    var value: String
    )
{
    fun updateValue(token: String): RefreshToken {
        this.value = token
        return this
    }

    fun RefreshToken(key: String?, value: String?) {
        this.key = key!!
        this.value = value!!
    }
}