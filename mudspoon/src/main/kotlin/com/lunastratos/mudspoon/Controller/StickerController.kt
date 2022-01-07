package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import com.lunastratos.mudspoon.Entity.StickerEntity
import com.lunastratos.mudspoon.Service.StickerService
import com.lunastratos.mudspoon.Util.BoardPaging
import com.lunastratos.mudspoon.Util.CommonUtil
import com.lunastratos.mudspoon.Util.File.FileManager
import org.apache.commons.io.FilenameUtils
import org.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


/**
 * 짤방 Controller
 * 짤방 게시판 담당
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-07 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
@RestController()
@RequestMapping("/Sticker")
class StickerController @Autowired constructor(
    private val stickerService: StickerService,
){

    private val log: Logger = LoggerFactory.getLogger(StickerController::class.java)

    /**
     * List - 리스트
     * desc: 페이지가 있을 경우
     * @param page Int
     * @param title String
     * */
    @RequestMapping("/board/list/{page}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun list(
        @PathVariable("page",  required = true) page: String,
        @RequestParam("search",  required = true, defaultValue = "") search: String
    ): ResponseEntity<*>? {

        var result = CommonUtil().getResultJson()

        try {

            println("${page} ${search}")

            val allCount = stickerService.allCount()
            val startEndData = BoardPaging(allCount.toInt(), page.toInt())
            val startPage = startEndData.startPage
            var endPage = startEndData.endPage

            val getBoardList = stickerService.selectBoardList(startPage.toLong(), search)
            result.put("list", getBoardList)
            result.put("startPage", startPage)
            result.put("endPage", endPage)

            return ResponseEntity.ok<Any>(result.toString())

        }catch (e:Exception){

            result.put("status", 9000)
            return ResponseEntity.badRequest()
                .body<Any>(result.toString())

        }
    }


    /**
     * 게시물 조회
     * desc: 페이지가 있을 경우
     * @param num String
     * */
    @RequestMapping("/board/view/{num}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun BoardNum(
        @PathVariable("num",  required = true) num: String
    ): ResponseEntity<*>? {

        var result = CommonUtil().getResultJson()

        try {

            println("${num} ")

            val getBoard = stickerService.selectBoardNum(num.toLong())
            result.put("data", getBoard)

            return ResponseEntity.ok<Any>(result.toString())

        }catch (e:Exception){

            result.put("status", 9000)
            return ResponseEntity.badRequest()
                .body<Any>(result.toString())

        }
    }


    @RequestMapping("/board/upload", method = arrayOf(RequestMethod.POST))
    fun upload(
        @RequestParam("contents", required = true) contents : String,
        @RequestParam("title", required = true) title : String,
        @RequestParam("tag", required = true) tag : String,
        @RequestParam("uploadFile", required = true) mf: MultipartFile
    ): ResponseEntity<*>? {
        var result = CommonUtil().getResultJson()

        try {
            val author = ""

            val originalFileName = mf!!.originalFilename // 업로드하는 파일 name

            var extensionName:String = FilenameUtils.getExtension(originalFileName)
            var fileName:String = FilenameUtils.getName(originalFileName)

            //확장자 검사
            var isExtension :Boolean = false
            val fileExtension = arrayOf("7z", "zip")
            for (item in fileExtension){
                if(extensionName.equals(item)) isExtension = true
            }

            if (isExtension){

                val uploadFileName = FileManager().fileUpload(mf)
                FileManager().unZip(uploadFileName)

                // Todo : DB에 파일이름 저장
                var stickerEntity = StickerEntity()
                    stickerEntity.auther = author
                    stickerEntity.contents = contents
                    stickerEntity.file_name_zip = uploadFileName+".zip"
                    stickerEntity.file_folder = uploadFileName
                    stickerEntity.search_tag = tag
                    stickerEntity.title = title
                    stickerService.insertSticker(stickerEntity)

                return ResponseEntity.ok<Any>(result.toString())

            }else{
                //지원 가능한 파일아님
            }

        }catch (e:Exception){


        }
        result.put("status", 9000)
        return ResponseEntity.badRequest()
            .body<Any>(result.toString())

    }


    /**
     * 게시물 삭제
     * desc: 토큰 조회해서 본인만 삭제가능
     * @param payLoad String (Json)
     * @param num String
     * */
    @RequestMapping("/board/delete/{num}", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun DeleteBoardNum(
        @RequestBody payLoad: String,
        @PathVariable("num",  required = true) num: String
    ): ResponseEntity<*>? {

        var result = CommonUtil().getResultJson()

        try {

            var param = JSONObject(payLoad)

            val response = stickerService.deleteBoardNum(num.toLong())
            result.put("data", response)
            return ResponseEntity.ok<Any>(result.toString())

        }catch (e:Exception){

            result.put("status", 9000)
            return ResponseEntity.badRequest()
                .body<Any>(result.toString())

        }
    }

}