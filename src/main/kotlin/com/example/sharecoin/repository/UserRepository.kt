package com.example.sharecoin.repository;

import com.example.sharecoin.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username=?1")
    fun findByUsername(username: String?): User?

    @Query("SELECT max(u.id) FROM User u")
    fun getLastId(): Long
}