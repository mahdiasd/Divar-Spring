package com.divar.spring.core.user

import com.divar.spring.core.user.entity.User
import com.divar.spring.core.user.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,

    ) {

    fun hashPassword(password: String): String {
        return BCryptPasswordEncoder().encode(password)
    }

    fun save(user: User): User {
        return repository.save(user.copy(password = hashPassword(user.password)))
    }

    fun findByMobile(mobile: String?): User? {
        if (mobile.isNullOrEmpty()) return null
        return repository.findByMobile(mobile)
    }
}