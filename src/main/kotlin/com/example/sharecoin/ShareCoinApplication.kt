package com.example.sharecoin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
class ShareCoinApplication

fun main(args: Array<String>) {
    runApplication<ShareCoinApplication>(*args)
}
