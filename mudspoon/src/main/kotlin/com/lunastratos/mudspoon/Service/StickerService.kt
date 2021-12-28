package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.StickerEntity
import com.lunastratos.mudspoon.Repository.QStickerRepository
import com.lunastratos.mudspoon.Repository.StickerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StickerService  @Autowired constructor(
    private val zzalRepo: StickerRepository,
    private val qZzalRepo: QStickerRepository
){

    @Transactional
    fun insertSticker(stickerEntity: StickerEntity) {
        qZzalRepo?.insertSticker(stickerEntity)
    }

    @Transactional
    fun selectBoardNum(boardNum: Long) {
        qZzalRepo?.selectBoardNum(boardNum)
    }
}