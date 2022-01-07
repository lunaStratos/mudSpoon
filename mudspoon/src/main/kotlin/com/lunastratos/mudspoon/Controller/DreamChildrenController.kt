package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import com.lunastratos.mudspoon.Service.DreamChildrenMapService
import com.lunastratos.mudspoon.Util.CommonUtil
import org.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dreamChildren")
class DreamChildrenController @Autowired constructor(
    private val dcService: DreamChildrenMapService,
    private val naverApi: NaverApi
) {

    private val log: Logger = LoggerFactory.getLogger(DreamChildrenController::class.java)

    /**
     * [지도 검색]
     * */
    @RequestMapping("/setSouce", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun mapSearch(
        @RequestBody payLoad: String
    ): ResponseEntity<*>? {

        var result = CommonUtil().getResultJson()

        try {

            var param = JSONObject(payLoad)

            val longitude :Double = param.getDouble("lng")
            val latitude :Double = param.getDouble("lat")

            // Todo 위경도 검사 쿼리
            val searchResult = dcService.selectSearchStore(longitude, latitude);
            result.put("data", searchResult)

            return ResponseEntity.ok<Any>(result.toString())
        }catch (e:Exception){

            result.put("status", 9000)
            return ResponseEntity.badRequest().body<Any>(result.toString())
        }
    }



}