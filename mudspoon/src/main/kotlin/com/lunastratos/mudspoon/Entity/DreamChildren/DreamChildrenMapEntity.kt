package com.lunastratos.mudspoon.Entity.DreamChildren

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name ="t_dream_children_map")
    data class DreamChildrenMapEntity (

        @Id
        @GeneratedValue
        val id : Long? = 0,
        @Column(name="store_name")
        val storeName :String = "",    // 가게이름
        @Column(name="store_code")
        val stoteCode :String = "01",
        @Column(name="si")
        val si :String = "",
        @Column(name="gungu")
        val gungu :String = "",              // 시군구명
        @Column(name="sigungu_code")
        val sigunguCode :String = "01",     // 시군구 코드

        val address :String = "",           // 주소
        @Column(name="address_lagacy")
        val address_lagacy :String = "01",  //소재지 지번주소
        val tel :String = "",  //전화번호

        @Column(name="main_operation_start_time", length = 5)
        val mainOperationStartTime :String = "",  // 평일운영시작시간
        @Column(name="main_operation_end_time", length = 5)
        val mainOperationEndTime :String = "",  // 평일운영종료시각

        @Column(name="sat_operation_start_time", length = 5)
        val satOperationStartTime :String = "",  // 토요일 운영시작시간
        @Column(name="sat_operation_end_time", length = 5)
        val satOperationEndTime :String = "",  // 토요일 운영종료시간

        @Column(name="holyday_operation_start_time", length = 5)
        val holydayOperationStartTime :String = "",  // 공휴일운영시작시간
        @Column(name="holyday_operation_end_time", length = 5)
        val holydayOperationEndTime :String = "",  // 공휴일운영종료시간

        @Column(name="delivery_start_time")
        val deliveryStartTime :String = "",  // 배달시작시간
        @Column(name="delivery_end_time")
        val deliveryEndTime :String = "",  // 배달종료시간

        @Column(name="management_agency")
        val managementAgency :String = "",  // 관리기관명
        @Column(name="management_agency_tel")
        val managementAgencyTel :String = "",  // 관리기관전화번호

        val longitude :Double?= 0.0,
        val latitude :Double?= 0.0,

        @Column(name="updated_at")
        var updatedAt: LocalDateTime? = LocalDateTime.now(),
        @Column(name="created_at")
        var createdAt: LocalDateTime? = LocalDateTime.now()
)