package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.StickerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StickerRepository : JpaRepository<StickerEntity?, Long?>