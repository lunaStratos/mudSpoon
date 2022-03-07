package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.LoungeEntity
import com.lunastratos.mudspoon.Repository.LoungeRepository
import com.lunastratos.mudspoon.Repository.QLoungeRepository
import com.lunastratos.mudspoon.Util.BoardPaging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoungeService @Autowired constructor(
    private val loungeRepo: LoungeRepository,
    private val QLoungeRepo: QLoungeRepository
){

   fun save(entity: LoungeEntity){
       loungeRepo.save(entity)
   }

    /**
     * 게시판 리스트
     *
     * QueryDsl을 이용해서 작동
     *
     * @param page :
     * @param title :
     * */
    fun selectBoardList(start: Long, search:String) : List<LoungeEntity> {
        var response: List<LoungeEntity>

        // 검색어 있으면 검색조건 실행됨
        if(!search.equals("")){
            response = QLoungeRepo.selectBoardSearchList(start, search)
        }else{
            response = QLoungeRepo.selectBoardList(start)
        }

        return response
    }

    /**
     * 게시판 전체 리스트 갯수
     *
     * */
    fun allCount() : Int{
        val response = loungeRepo.count().toInt()
        return response
    }
}