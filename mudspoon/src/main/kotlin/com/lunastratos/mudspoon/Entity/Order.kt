package com.lunastratos.mudspoon.Entity

import javax.persistence.*

@Entity
@Table(name ="t_order")
class Order {
    @Id
    @Column(name = "ORDER_ID")
    private val id: String? = null
    private val name: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false, updatable = false)
    lateinit var member: Member

}