package com.example.sharecoin.controller

import com.example.sharecoin.entity.Message
import com.example.sharecoin.entity.User
import com.example.sharecoin.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping


@Controller
class RegistrationController {
    @Autowired
    private lateinit var userService: UserService

    @PostMapping("/registration")
    fun addUser(@ModelAttribute("userForm") userForm: User): Message {
        if(!userService.saveUser(userForm)){
            return Message("User has just existed")
        }
        return Message("User has added successful")
    }
}