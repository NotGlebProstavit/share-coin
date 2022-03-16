package com.example.sharecoin.entity

import java.io.*
import javax.validation.constraints.NotEmpty

class UserSerialize(
    @NotEmpty
    val username: String? = null,
    @NotEmpty
    val password: String? = null
): Serializable