package com.example.sharecoin.controller

import com.example.sharecoin.entity.UserSerialize
import com.example.sharecoin.exception.UserAlreadyExistException
import com.example.sharecoin.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.net.http.HttpResponse
import javax.validation.Valid

@Controller
class RegistrationController {
    @Autowired
    @org.springframework.context.annotation.Lazy
    lateinit var userService: UserService

    @GetMapping("/registration")
    @ResponseBody
    fun registration(): String = "It's URL for registration"

    @PostMapping("/registration")
    @ResponseBody
    fun userRegistration(@Valid @RequestBody user: UserSerialize, bindingResult: BindingResult): HttpStatus{
        if(bindingResult.hasErrors()){
            throw Exception("Error in registration")
        }
        try{
            userService.register(user)
        } catch (e: UserAlreadyExistException){
            throw e
        }
        return HttpStatus.CREATED
    }
}