package com.lunastratos.mudspoon.Util

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import java.security.spec.AlgorithmParameterSpec
import javax.crypto.spec.SecretKeySpec
import javax.crypto.SecretKey
import java.io.ByteArrayOutputStream
import java.lang.Exception
import java.nio.charset.Charset
import java.security.SecureRandom
import java.util.*

/**
 * 암호화 모듈
 * @version     1.0
 * @author      LunaStratos
 * */
class AES_Encryption {

    var key : String = "C&F)J@NcRfUjXn2r4u7x!A%D*G-KaPdS";

    @Throws(Exception::class)
    fun encrypt(plainText: String): String? {
        val keyspec: SecretKey = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")

        //set iv as random 16byte
        val ivSize = 16
        val iv = ByteArray(ivSize)
        val random = SecureRandom()
        random.nextBytes(iv)
        val ivspec: AlgorithmParameterSpec = IvParameterSpec(iv)

        // Encryption
        val cipher = Cipher.getInstance("AES/CBC/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec)
        val blockSize = 128 //block size
        val dataBytes = plainText.toByteArray(charset("UTF-8"))

        //find fillChar & pad
        var plaintextLength = dataBytes.size
        val fillChar = blockSize - plaintextLength % blockSize
        plaintextLength += fillChar //pad
        val plaintext = ByteArray(plaintextLength)
        Arrays.fill(plaintext, fillChar.toByte())
        System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.size)

        //encrypt
        val cipherBytes = cipher.doFinal(plaintext)

        //add iv to front of cipherBytes
        val outputStream = ByteArrayOutputStream()
        outputStream.write(iv)
        outputStream.write(cipherBytes)

        //encode into base64
        val encryptedIvText = outputStream.toByteArray()
        return String(Base64.getEncoder().encode(encryptedIvText), Charset.forName("UTF-8"))
    }

    @Throws(Exception::class)
    fun decrypt(encryptedIvText: String?): String? {
        //decode with base64 decoder
        val encryptedIvTextBytes: ByteArray = Base64.getDecoder().decode(encryptedIvText)

        // Extract IV.
        val ivSize = 16
        val iv = ByteArray(ivSize)
        System.arraycopy(encryptedIvTextBytes, 0, iv, 0, iv.size)

        // Extract encrypted part.
        val encryptedSize = encryptedIvTextBytes.size - ivSize
        val encryptedBytes = ByteArray(encryptedSize)
        System.arraycopy(encryptedIvTextBytes, ivSize, encryptedBytes, 0, encryptedSize)


        // Decryption
        val cipher = Cipher.getInstance("AES/CBC/NoPadding")
        val keyspec: SecretKey = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")
        val ivspec: AlgorithmParameterSpec = IvParameterSpec(iv)
        cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec)
        val aesdecode = cipher.doFinal(encryptedBytes)

        // unpad
        val origin = ByteArray(aesdecode.size - aesdecode[aesdecode.size - 1])
        System.arraycopy(aesdecode, 0, origin, 0, origin.size)
        return String(origin, Charset.forName("UTF-8"))
    }

}