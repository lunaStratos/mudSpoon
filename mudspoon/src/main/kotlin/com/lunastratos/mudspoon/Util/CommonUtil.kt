package com.lunastratos.mudspoon.Util

import org.json.JSONObject

/**
 * 일반 유틸
 * 일반 유틸 로직 담당
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-07 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
class CommonUtil {

    fun test() : String{
        return "test"
    }

    fun getResultJson() : JSONObject{
        var result = JSONObject()
        result.put("status" , 1000)
        return result
    }
}