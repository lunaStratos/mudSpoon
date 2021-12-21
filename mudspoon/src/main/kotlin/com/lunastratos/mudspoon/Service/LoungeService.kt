package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.MongoDB.LoungeEntity
import com.lunastratos.mudspoon.Repository.LoungeRepository
import com.lunastratos.mudspoon.Repository.QLoungeRepository
import com.lunastratos.mudspoon.Util.BoardPaging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoungeService @Autowired constructor(
    private val loungeRepo: LoungeRepository,
    private val QLungeRepository: QLoungeRepository
){

   fun save(entity: LoungeEntity){
       loungeRepo.save(entity)
   }

    /**
     * 게시판 리스트
     *
     * @param page :
     * @param title :
     * */
    fun selectBoardList(page: Int, title:String){
        val allCount = loungeRepo.count().toInt()
        val startEndArray = BoardPaging(allCount, page)

        // 검색어 있으면 검색조건 거침
        if(!title.equals("")){

        }



    }
}