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
     * */

    private lateinit var webClient: WebClient

    // Redirect URL
    @Value("\${kakaoApi.redirectURI}")
    lateinit var redirectURI :String

    // kakaoApi client_id
    @Value("\${kakaoApi.client_id}")
    lateinit var client_id :String

    // kakaoApi client_secret
    @Value("\${kakaoApi.client_secret}")
    lateinit var client_secret :String

    /**
     * 네이버 로그인 페이지
     * desc: GET/POST 둘다가능
     * */
    fun getSocialLoginAutherize () : String? {
        this.webClient = WebClient.create("https://nid.naver.com/oauth2.0")

        val response = webClient.get()
            .uri{uriBuilder -> uriBuilder.path("/authorize")
                .queryParam("response_type", "code")
                .queryParam("client_id", client_id)
                .queryParam("state",  (Math.random()*10).toInt())
                .queryParam("redirect_uri", redirectURI)
                .build()}

            .retrieve().bodyToMono(String::class.java)
            .block()
        return response
    }

    /**
     * 네이버 token 페이지
     * desc: GET/POST 둘다 가능
     * */
    fun getSocialLoginToken (code:String, state :String) : String? {
        this.webClient = WebClient.create("https://nid.naver.com/oauth2.0")

        val response = webClient.post()
            .uri{uriBuilder -> uriBuilder.path("/token")
            .queryParam("grant_type", "authorization_code")
            .queryParam("client_id", client_id)
            .queryParam("client_secret", client_secret)
            .queryParam("code", code)
            .queryParam("state", state)
            .build()}
            .retrieve().bodyToMono(String::class.java)
            .block()
        return response
    }

    /**
     * 네이버 token 페이지
     * desc: GET/POST 둘다 가능
     * */
    fun getSocialLoginMeInfo (access_token:String) : String? {
        this.webClient = WebClient.create("https://openapi.naver.com/v1/nid/me")

        val response = webClient.post()
            .header("Authorization" , "Bearer ${access_token}")
            .retrieve().bodyToMono(String::class.java)
            .block()
        return response
    }


    fun testPostApi (clientId:String, state :String) : String? {
        this.webClient = WebClient.create("https://reqbin.com/echo/post/")

        val response = webClient.post()
            .uri{uriBuilder -> uriBuilder.path("/json")
                .queryParam("client_id", 1)
                .queryParam("state", 2)
                .build()}

            .retrieve().bodyToMono(String::class.java)
            .block()
        return response
    }

    fun testGetApi (clientId:String, state :String) : String? {
        this.webClient = WebClient.create("https://httpbin.org/")

        val response = webClient.get()
            .uri{uriBuilder -> uriBuilder.path("get")
                .queryParam("ok", 1)
                .build()
            }
            .retrieve().bodyToMono(String::class.java)
            .block()
        return response
    }
}