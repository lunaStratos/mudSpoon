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
    private val QLungeRepo: QLoungeRepository
){

   fun save(entity: LoungeEntity){
       loungeRepo.save(entity)
   }

    /**
     * 게시판 리스트
     *
     * QueryDsl을 이용해서
     *
     * @param page :
     * @param title :
     * */
    fun selectBoardList(page: Int, search:String) : List<LoungeEntity> {
        val allCount = loungeRepo.count().toInt()
        val startEndArray = BoardPaging(allCount, page)

        var response: List<LoungeEntity>

        // 검색어 있으면 검색조건 거침
        if(!search.equals("")){
            val start = startEndArray.startPage
            response = QLungeRepo.selectBoardSearchList(start.toLong(), search)
        }else{
            val start = startEndArray.startPage
            response = QLungeRepo.selectBoardList(start.toLong())
        }

        return response
    }
}