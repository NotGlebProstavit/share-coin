package com.example.sharecoin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class APIController {
    @GetMapping("/")
    @ResponseBody
    fun testMain(): String{
        return "/main page"
    }

    @GetMapping("/user")
    @ResponseBody
    fun testUsers(): String{
        return "/user page"
    }
}