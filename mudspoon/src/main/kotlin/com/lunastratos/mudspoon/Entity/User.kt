package com.lunastratos.mudspoon.Entity

import javax.persistence.*


@Entity
class User {
    @Id
    private val id: Int? = null
    private val name: String? = null
    private val level: String? = null

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private val articleList: List<Article>? = null

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private val team: Team? = null
}