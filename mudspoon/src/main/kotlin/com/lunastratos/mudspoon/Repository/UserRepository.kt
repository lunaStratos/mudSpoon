package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity?, Long?>{

}