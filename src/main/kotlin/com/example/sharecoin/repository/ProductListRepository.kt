package com.example.sharecoin.repository

import com.example.sharecoin.entity.ProductList
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductListRepository: JpaRepository<ProductList, Long>