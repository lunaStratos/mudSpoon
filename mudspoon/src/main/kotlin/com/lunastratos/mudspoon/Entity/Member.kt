package com.lunastratos.mudspoon.Entity

import javax.persistence.*


@Entity
@Table(name ="t_member")
class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private val id: String? = null
    private val username: String? = null

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private val order: Order? = null
}