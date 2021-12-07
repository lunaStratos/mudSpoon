package com.lunastratos.mudspoon.Api.External

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

/**
 * 카카오 Api 모음
 * @date        2021-12-07
 * @version     1.0
 * @author      Auther : LunaStratos (LunaStratos@gmail.com)
 * */
@Service
class KaKaoApi {

    /**
     * 각 위치
     * client_id & client_secret & redirectURI
     *
     * 설명: https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api
     * */

    private var webClient: WebClient = WebClient.create("kauth.kakao.com")

    // Redirect URL
    @Value("\${kakaoApi.redirectURI}")
    lateinit var redirectURI :String

    // kakaoApi client_id
    @Value("\${kakaoApi.rest_api_client_id}")
    lateinit var client_id :String

    // kakaoApi client_secret
    @Value("\${kakaoApi.client_secret}")
    lateinit var client_secret :String

    /**
     * 카카오 로그인 페이지
     * desc: GET/POST 둘다가능
     * */
    fun getSocialLoginAutherize () : String? {

        val response = webClient.get()
            .uri{uriBuilder -> uriBuilder.path("/oauth/authorize")
                .queryParam("client_id", client_id)
                .queryParam("response_type", "code")
                .queryParam("state",  (Math.random()*10).toInt())
                .queryParam("redirect_uri", redirectURI)
                .build()}

            .retrieve().bodyToMono(String::class.java)
            .block()
        return response
    }

    /**
     * 카카오 token 페이지
     * desc: GET/POST 둘다 가능
     * */
    fun getSocialLoginToken (code:String) : String? {

        val response = webClient.post()
            .uri{uriBuilder -> uriBuilder.path("/oauth/token")
            .queryParam("grant_type", "authorization_code")
            .queryParam("client_id", client_id)
            .queryParam("client_secret", client_secret)
            .queryParam("code", code)
            .queryParam("redirect_uri", redirectURI)
            .build()}
            .header("Content-Type", "application/x-www-form-urlencoded")
            .retrieve().bodyToMono(String::class.java)
            .block()
        return response
    }

    /**
     * 카카오 token 페이지
     * desc: GET/POST 둘다 가능
     * */
    fun getSocialLoginMeInfo (access_token:String) : String? {
        this.webClient = WebClient.create("https://openapi.naver.com/v1/nid/me")

        val response = webClient.post()
            .header("Authorization" , "Bearer ${access_token}")
            .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
            .retrieve().bodyToMono(String::class.java)
            .block()
        return response
    }


}