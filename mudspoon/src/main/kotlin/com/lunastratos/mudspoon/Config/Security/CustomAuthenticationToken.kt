package com.lunastratos.mudspoon.Config.Security

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority


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