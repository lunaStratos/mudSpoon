package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.DreamChildren.DreamChildrenMapEntity
import com.lunastratos.mudspoon.Entity.TestEntity
import com.lunastratos.mudspoon.Repository.DreamChildrenMap.DreamChildrenMapRepository
import com.lunastratos.mudspoon.Repository.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DreamChildrenMapService  @Autowired constructor(
    private val dcRepo: DreamChildrenMapRepository
){

    fun selectSearchStore(longitude:Double, latitude: Double):List<DreamChildrenMapEntity> {
        return dcRepo!!.selectSearchStore(longitude, latitude)
    }
}