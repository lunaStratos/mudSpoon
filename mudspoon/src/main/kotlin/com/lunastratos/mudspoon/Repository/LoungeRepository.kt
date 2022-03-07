package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.LoungeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

/**
 * Lounge Repository
 *
 * 라운지 DB 연결시 사용
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-13 초기작성
 *
 * @date        2021-12-13
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */

@Repository
interface LoungeRepository : JpaRepository<LoungeEntity, Long>