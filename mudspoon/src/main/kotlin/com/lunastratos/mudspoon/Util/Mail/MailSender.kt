package com.lunastratos.mudspoon.Util.Mail

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

/**
 * 인증메일 보내기
 * @version     1.0
 * @author      LunaStratos
 * */
//@Service
class MailSender {

//    @Autowired
//    lateinit var javaMailSender: JavaMailSender
//
//    fun mailSend(email: String, token: String) {
//        val mimeMessage = javaMailSender.createMimeMessage()
//        val mimeMessageHelper = MimeMessageHelper(mimeMessage)
//
//        mimeMessageHelper.setSubject("[흙수저프랜즈] 인증메일 입니다.")
//        mimeMessageHelper.setTo(email)
//
//        val html:String = "<html> <body> <h3>인증메일 입니다.<h3> " +
//                "<br>아래의 링크를 눌러서 인증해 주세요." +
//                "<br> 인증번호: ${token} " +
//                "<br> 위 링크가 안된다면 아래의 창에서 인증하여 주십시오." +
//                "<br> <a href='http://local.xrland.net/register?email=${email}'>인증페이지</a>" +
//                "</body></html>"
//        mimeMessageHelper.setText(html, true )
//
//        javaMailSender.send(mimeMessage)
//    }

}
