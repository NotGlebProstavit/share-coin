package com.example.sharecoin.repository;

import com.example.sharecoin.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RoleRepository : JpaRepository<Role, Long>{
    @Query("SELECT r FROM Role r WHERE r.name=?1")
    fun findByName(name: String?): Role?
}