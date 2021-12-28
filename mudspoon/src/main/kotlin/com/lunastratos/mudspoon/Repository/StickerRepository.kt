package com.lunastratos.mudspoon.Repository

import com.lunastratos.mudspoon.Entity.StickerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StickerRepository : JpaRepository<StickerEntity?, Long?>