package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.LoungeEntity
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

    /**
     * 게시물 조회
     * */
    fun selectBoardNum(boardNum: Long) : List<StickerEntity> {
        return qZzalRepo?.selectBoardNum(boardNum)
    }

    /**
     * 게시물 삭제
     * */
    fun deleteBoardNum(boardNum: Long) :Long{
        return qZzalRepo?.deleteBoardNum(boardNum)
    }

    /**
     * 게시판 리스트
     *
     * QueryDsl을 이용해서 작동
     *
     * @param page :
     * @param title :
     * */
    fun selectBoardList(start: Long, search:String) : List<StickerEntity> {
        var response: List<StickerEntity>

        // 검색어 있으면 검색조건 실행됨
        if(!search.equals("")){
            response = qZzalRepo.selectBoardSearchList(start, search)
        }else{
            response = qZzalRepo.selectBoardList(start)
        }

        return response
    }

    fun allCount():Long{
        return zzalRepo.count();
    }
}