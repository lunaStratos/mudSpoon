package com.lunastratos.mudspoon.Repository.DreamChildrenMap

import com.lunastratos.mudspoon.Entity.DreamChildren.DreamChildrenMapEntity
import com.lunastratos.mudspoon.Entity.TestEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * 전국아동급식정보
 * 참조: https://www.data.go.kr/data/15034530/standard.do
 * 마지막 갱신날짜 : 2022 01 07
 * */
@Repository
interface DreamChildrenMapRepository : JpaRepository<DreamChildrenMapEntity?, Long?>{

    /**
     * 위경도로 주변 검색 쿼리
     * @param longitude Double
     * @param latitude Double
     * */
    @Query("""
        SELECT
            *, SQRT( POW( ( (69.1/1.61) * (:latitude - A.latitude)), 2) + POW(( (53/1.61) * (:longitude - A.longitude)), 2)) AS distance
            
            FROM t_dream_children_map A        
            WHERE
                
            A.latitude > :latitude - 10 / (69.1/1.61)
            AND A.latitude < :latitude + 10 / (69.1/1.61)
            AND A.longitude > :longitude - 10 / (53/1.61)
            AND A.longitude < :longitude + 10 / (53/1.61)
            HAVING distance < 1
            order by distance asc
        
    """, nativeQuery = true)
    fun selectSearchStore(@Param("longitude") longitude: Double,
                    @Param("latitude") latitude: Double): List<DreamChildrenMapEntity>

}