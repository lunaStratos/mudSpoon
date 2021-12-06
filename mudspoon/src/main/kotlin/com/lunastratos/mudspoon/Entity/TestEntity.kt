package com.lunastratos.mudspoon.Entity

import javax.persistence.*

@Entity
@Table(name ="t_test")
data class TestEntity (

    @Id
    @GeneratedValue
    val id : Long? = 0,
    @Column(name="test_str")
    val testStr :String? = "",
    val testInt :Int?= 0
)