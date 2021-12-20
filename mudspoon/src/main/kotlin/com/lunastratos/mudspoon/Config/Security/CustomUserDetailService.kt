package com.lunastratos.mudspoon.Config.Security

import com.lunastratos.mudspoon.Entity.UserEntity
import com.lunastratos.mudspoon.Entity.UserPrincipal
import com.lunastratos.mudspoon.Repository.QUserRepository
import com.lunastratos.mudspoon.Repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


/**
 * UserDetailsService
 * desc: Spring security - DB 접속 서비스
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-15 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@Service
class CustomUserDetailService(
    private val userRepo: UserRepository,
    private val QUserRepo: QUserRepository,
) : UserDetailsService{

    //password는 알아서 처리된다.
    override fun loadUserByUsername(username: String): UserDetails {
        val userList:List<UserEntity> =  QUserRepo.selectUserByEmail(username)
        if(userList.isEmpty()){
            return throw UsernameNotFoundException("해당 사용자가 없습니다.")
        }

        //"{noop}" +
        val value = UserPrincipal(
            userList[0].email,
            userList[0].name,
            userList[0].password,
            listOf<GrantedAuthority>(SimpleGrantedAuthority(userList[0].roleType!!.name))
        )

        println("value : " + value.password + "  " + value.username + " " + value)
        return value
    }

    fun selectUserByEmail(email:String): List<UserEntity> = QUserRepo.selectUserByEmail(email)

}