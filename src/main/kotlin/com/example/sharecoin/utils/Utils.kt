package com.example.sharecoin.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

object Utils {
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}