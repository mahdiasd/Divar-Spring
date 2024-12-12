package com.divar.spring.core.user.dto

import com.divar.spring.core.user.entity.User
import java.time.Instant

data class UserResponse(
    val name: String,

    val family: String,

    val email: String,

    val token: String,

    val mobile: String,

    val createAt: Instant?,

    val updatedAt: Instant?,
)

fun User.toResponse(token: String): UserResponse {
    return UserResponse(
        name = name,
        family = family,
        email = email,
        token = token,
        mobile = mobile,
        createAt = createAt,
        updatedAt = updatedAt
    )
}