package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.Member
import com.lunastratos.mudspoon.Entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<User, Long>