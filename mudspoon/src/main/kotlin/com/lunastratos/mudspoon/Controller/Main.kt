package com.lunastratos.mudspoon.Controller

import org.springframework.web.bind.annotation.*

@RestController
class MainController {

    @RequestMapping("/test", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun test(): String {
        return "test"
    }

    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun main(): String {
        return "main"
    }
}