package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import com.lunastratos.mudspoon.Entity.Domain.LatLngDomain
import com.lunastratos.mudspoon.Service.DreamChildrenMapService
import com.lunastratos.mudspoon.Util.CommonUtil
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException

/**
 * Controller
 * 꿈의아이들 지도 담당
 *
 * History:
 *    LunaStratos, 1.0, 2022-01-09 초기작성
 *
 * @date        2022-01-09
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@RestController
@RequestMapping("/dreamChildren")
@Api(value = "DreamChildrenController", description = "꿈의 아이들 단기 프로젝트 컨트롤러")
class DreamChildrenController @Autowired constructor(
    private val dcService: DreamChildrenMapService,
    private val naverApi: NaverApi
) {

    private val log: Logger = LoggerFactory.getLogger(DreamChildrenController::class.java)

    /**
     * [지도 검색]
     *
     * @param payLoad String [lng: 경도, lat : 위도]
     * */
    @RequestMapping("/searchStore", method = arrayOf(RequestMethod.POST))
    @ApiOperation(value="{lat: 37.2823, lng: 127.18940}", notes="위경도를 json 형태로 받는 곳")
    @ResponseBody
    fun mapSearch(
        @RequestBody payLoad: LatLngDomain
        //@ModelAttribute payLoad : LatLngDomain
    ): ResponseEntity<*>? {

        var result = CommonUtil().getResultJson()

        try {

            val longitude :Double = payLoad.lng
            val latitude :Double = payLoad.lat

            // Todo 위경도 검사 쿼리
            val searchResult = dcService.selectSearchStore(longitude, latitude);
            result.put("data", searchResult)

            return ResponseEntity.ok<Any>(result.toString())
        }catch (e:Exception){

            result.put("status", 9000)
            return ResponseEntity.badRequest().body<Any>(result.toString())
        }
    }

    /**
     * [지도 검색]
     *
     * @param payLoad String
     * */
    @RequestMapping("/test", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun test(): ResponseEntity<*>? {

        var result = CommonUtil().getResultJson()

        try {

            return ResponseEntity.ok<Any>(result.toString())
        }catch (e:Exception){

            result.put("status", 9000)
            return ResponseEntity.badRequest().body<Any>(result.toString())
        }
    }



}