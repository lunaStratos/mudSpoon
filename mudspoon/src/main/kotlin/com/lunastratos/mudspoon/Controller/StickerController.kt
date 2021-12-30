package com.lunastratos.mudspoon.Controller

import com.lunastratos.mudspoon.Api.External.NaverApi
import com.lunastratos.mudspoon.Entity.StickerEntity
import com.lunastratos.mudspoon.Service.StickerService
import com.lunastratos.mudspoon.Util.File.FileManager
import org.apache.commons.io.FilenameUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
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
    private val naverApi: NaverApi,
    private val stickerService: StickerService,
){

    private val log: Logger = LoggerFactory.getLogger(StickerController::class.java)

    @RequestMapping("/list", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun list(): String {
        return "zz"
    }


    @RequestMapping("/board/upload", method = arrayOf(RequestMethod.POST))
    fun upload(
        @RequestParam("contents", required = true) contents : String,
        @RequestParam("title", required = true) title : String,
        @RequestParam("tag", required = true) tag : String,
        @RequestParam("uploadFile", required = true) mf: MultipartFile


    ): String? {

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
        }else{
            //지원 가능한 파일아님
        }





        return ""
    }


}