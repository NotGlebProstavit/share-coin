package com.example.sharecoin.controller

import com.example.sharecoin.entity.Message
import com.example.sharecoin.entity.User
import com.example.sharecoin.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class AdminController {
    @Autowired
    private val userService: UserService? = null
    @GetMapping("/admin")
    fun userList(model: Model): MutableCollection<User> {
        return userService!!.allUsers()
    }

    @PostMapping("/admin")
    fun deleteUser(
        @RequestParam(required = true, defaultValue = "") userId: Long?,
        @RequestParam(required = true, defaultValue = "") action: String,
    ): Message {
        if (action == "delete") {
            userService!!.deleteUser(userId)
            return Message("User has been deleted successful")
        }
        return Message("Unknown action")
    }
}