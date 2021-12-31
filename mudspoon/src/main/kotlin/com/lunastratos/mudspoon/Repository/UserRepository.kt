package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity?, Long?>