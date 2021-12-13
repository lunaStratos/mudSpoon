package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.LoungeEntity
import com.lunastratos.mudspoon.Repository.LoungeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoungeService @Autowired constructor(
    private val loungeRepo: LoungeRepository
){

   fun save(entity:LoungeEntity){
       loungeRepo.save(entity)
   }
}