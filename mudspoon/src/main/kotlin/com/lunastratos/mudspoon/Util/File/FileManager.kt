package com.lunastratos.mudspoon.Util.File

import com.lunastratos.mudspoon.Entity.StickerEntity
import com.lunastratos.mudspoon.Service.StickerService
import org.apache.commons.io.FilenameUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.charset.Charset
import java.util.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


/**
 * 파일매니져
 * 파일저장 담당
 *
 * History:
 *    LunaStratos, 1.0, 2021-12-07 초기작성
 *
 * @date        2021-12-07
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
class FileManager (){

    fun fileUpload(mf:MultipartFile):String{

        var uploadPath = ""
        var uploadFileName = ""

        try {
            val zipPath = "./uploadZip"
            val originalFileName = mf!!.originalFilename // 업로드하는 파일 name

            var fileName:String = FilenameUtils.getName(originalFileName)
            var extensionName:String = FilenameUtils.getExtension(originalFileName)

            uploadPath = zipPath + fileName + "_" + Calendar.getInstance().timeInMillis +"." + extensionName
            uploadFileName = fileName + "_" + Calendar.getInstance().timeInMillis
            mf.transferTo(File(uploadPath))
        }catch (e : IOException){

        }
        return uploadFileName
    }

    fun unZip(uploadFileName: String): Boolean {

        var zipUnzipPath = "./uploadImg/" + uploadFileName.replace(".zip", "")
        val filePath = "./uploadZip/$uploadFileName"
        var isChk = false

        // zip 파일
        var fis: FileInputStream? = null
        var zis: ZipInputStream? = null
        var zipentry: ZipEntry? = null
        try {
            // zipFileName을 통해서 폴더 만들기
            if (makeFolder(zipUnzipPath)) {
                println("폴더를 생성했습니다")
            }
            // 파일 스트림
            fis = FileInputStream(filePath)
            // Zip 파일 스트림
            zis = ZipInputStream(fis, Charset.forName("EUC-KR"))
            // 압축되어 있는 ZIP 파일의 목록 조회
            while (zis.nextEntry.also { zipentry = it } != null) {
                val filename = zipentry!!.name
                println("filename(zipentry.getName()) => $filename")
                val file = File(zipUnzipPath, filename)
                // entiry가 폴더면 폴더 생성
                if (zipentry!!.isDirectory) {
                    println("zipentry가 디렉토리입니다.")
                    file.mkdirs()
                } else {
                    // 파일이면 파일 만들기
                    println("zipentry가 파일입니다.")
                    try {
                        createFile(file, zis)
                    } catch (e: Throwable) {
                        e.printStackTrace()
                    }
                }
            }

            isChk = true
        } catch (e: Exception) {
            isChk = false
        } finally {
            if (zis != null) {
                try {
                    zis.close()
                } catch (e: IOException) {
                }
            }
            if (fis != null) {
                try {
                    fis.close()
                } catch (e: IOException) {
                }
            }
        }
        return isChk
    }

    private fun makeFolder(folder: String): Boolean {
        if (folder.length < 0) {
            return false
        }
        val Folder = File(folder)
        // 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
        if (!Folder.exists()) {
            try {
                Folder.mkdir() // 폴더 생성합니다.
                println("폴더가 생성되었습니다.")
            } catch (e: java.lang.Exception) {
                e.stackTrace
            }
        } else {
            println("이미 폴더가 생성되어 있습니다.")
        }
        return true
    }


    @Throws(Throwable::class)
    private fun createFile(file: File, zis: ZipInputStream) {
// 디렉토리 확인
        val parentDir = File(file.parent)
        // 디렉토리가 없으면 생성하자
        if (!parentDir.exists()) {
            parentDir.mkdirs()
        }
        var fos: FileOutputStream? = null
        // 파일 스트림 선언
        try {
            fos = FileOutputStream(file)
            val buffer = ByteArray(256)
            var size = 0
            // Zip스트림으로부터 byte뽑아내기
            while (zis.read(buffer).also { size = it } > 0) {
                // byte로 파일 만들기
                fos.write(buffer, 0, size)
            }
        } catch (e: Throwable) {
            throw e
        } finally {
            if (fos != null) {
                try {
                    fos.close()
                } catch (e: IOException) {
                }
            }
        }
    }

}