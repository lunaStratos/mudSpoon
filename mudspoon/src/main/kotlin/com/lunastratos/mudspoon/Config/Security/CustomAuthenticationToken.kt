package com.lunastratos.mudspoon.Config.Security

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority

/**
 * AbstractAuthenticationToken
 * desc: Spring security - DB VO 모듈
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-15 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
class CustomAuthenticationToken : AbstractAuthenticationToken {
    private var email: String? = null
    private var credentials: String? = null

    constructor(
        email: String?,
        credentials: String?,
        authorities: Collection<GrantedAuthority?>?
    ) : super(authorities) {
        this.email = email
        this.credentials = credentials
    }

    constructor(authorities: Collection<GrantedAuthority?>?) : super(authorities) {}

    override fun getCredentials(): Any {
        return credentials!!
    }

    override fun getPrincipal(): Any {
        return email!!
    }
}