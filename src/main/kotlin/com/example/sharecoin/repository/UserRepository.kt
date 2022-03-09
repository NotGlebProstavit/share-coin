package com.example.sharecoin.repository;

import com.example.sharecoin.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String?): User?
}