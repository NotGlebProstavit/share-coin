package com.example.sharecoin.repository

import com.example.sharecoin.entity.Product
import com.example.sharecoin.entity.User
import com.example.sharecoin.entity.UserProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserProductRepository: JpaRepository<UserProduct, Long> {

    @Query("SELECT c.count FROM UserProduct c WHERE c.user=?1 AND c.product=?2")
    fun getCount(user: User, product: Product): Double
}