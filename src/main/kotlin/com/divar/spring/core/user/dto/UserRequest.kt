package com.divar.spring.core.user.dto

import com.divar.spring.core.user.entity.User

data class UserRequest(
    val name: String? = null,

    val family: String? = null,

    val email: String? = null,

    val password: String,

    val mobile: String,

    val repeatPassword: String? = null,
)

fun UserRequest.toEntity(): User {
    return User(
        name = this.name ?: "",
        family = this.family ?: "",
        email = this.email ?: "",
        password = this.password,
        mobile = this.mobile
    )
}