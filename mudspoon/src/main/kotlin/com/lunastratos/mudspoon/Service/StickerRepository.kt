package com.lunastratos.mudspoon.Service

import com.lunastratos.mudspoon.Entity.StickerEntity
import com.lunastratos.mudspoon.Entity.TestEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StickerRepository : JpaRepository<StickerEntity?, Long?>{

}