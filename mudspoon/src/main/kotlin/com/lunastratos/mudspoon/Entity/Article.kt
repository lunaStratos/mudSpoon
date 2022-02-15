package com.lunastratos.mudspoon.Entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id


@Entity
class Article {
    @Id
    private val id: Int? = null

    @Column(name = "user_id")
    private val userId: Int? = null
    private val title: String? = null
}