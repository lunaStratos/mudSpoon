package com.lunastratos.mudspoon.Api

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

/**
 * * 네이버 Api 모음
 * @version     1.0
 * @author      Auther : LunaStratos (LunaStratos@gmail.com)
 * */
@Service
class NaverApi {

    /**
     * client_id & client_secret
     * https://developers.naver.com/apps/#/myapps
     *
     * */

    private lateinit var webClient: WebClient

    @Value("\${naverApi.redirectURI}")
    lateinit var redirectURI :String

    @Value("\${naverApi.client_id}")
    lateinit var client_id :String

    @Value("\${naverApi.client_secret}")
    lateinit var client_secret :String

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
        // http://localhost:8080/register?code=UQlNf5jLghPUdCXQmO&state=1234
    }


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