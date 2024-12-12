package com.divar.spring.core.user.repository

import com.divar.spring.core.user.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findByEmail(email: String): User?

    fun findByMobile(mobile: String): User?

}