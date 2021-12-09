package com.lunastratos.mudspoon.Entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class UserPrincipal(
    private val email: String?,
    private val name: String?,
    private val password: String?,
    private val authorities: Collection<GrantedAuthority>
): UserDetails {

    override fun getAuthorities() = this.authorities

    override fun getPassword() = this.password

    // !! 중요 UserDetails에서 PK로 활용될 속성을 설정해줍니다.
    override fun getUsername() = this.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

}