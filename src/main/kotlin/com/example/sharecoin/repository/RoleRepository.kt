package com.example.sharecoin.repository;

import com.example.sharecoin.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long>