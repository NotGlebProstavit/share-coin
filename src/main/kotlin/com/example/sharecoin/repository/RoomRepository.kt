package com.example.sharecoin.repository

import com.example.sharecoin.entity.Room
import org.springframework.data.jpa.repository.JpaRepository

interface RoomRepository: JpaRepository<Room, Long>