package com.divar.spring.core.user.controller

import com.divar.spring.utils.response.BadRequestError
import com.divar.spring.utils.response.UnauthorizedError
import com.divar.spring.core.user.UserService
import com.divar.spring.core.user.dto.UserRequest
import com.divar.spring.core.user.dto.toEntity
import com.divar.spring.core.user.dto.toResponse
import com.divar.spring.utils.response.ApiResponse
import com.divar.spring.utils.response.InvalidCredentialsError
import com.divar.spring.utils.security.JwtService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/")
class UserController(
    val service: UserService,
    val jwtService: JwtService
) {

    @PostMapping("user/register")
    fun register(
        @RequestBody userRequest: UserRequest? = null
    ): Any {
        return if (userRequest == null) ApiResponse.error(BadRequestError())
        else if (service.findByMobile(userRequest.mobile) != null) ApiResponse.error(BadRequestError(message = "کاربری با این شماره وجود دارد"))
        else if (userRequest.password != userRequest.repeatPassword) ApiResponse.error(BadRequestError(message = "رمز عبورها یکسان نیستند!"))
        else {
            val user = userRequest.toEntity()
            val token = jwtService.generate(user)
            val savedUser = service.save(user)
            val userResponse = savedUser.toResponse(token)
            return ApiResponse.success(userResponse)
        }
    }

    @PostMapping("user/login")
    fun login(
        @RequestBody userRequest: UserRequest? = null
    ): Any {
        if (userRequest == null) return ApiResponse.error(BadRequestError())
        service.findByMobile(userRequest.mobile)?.let { user ->
            val token = jwtService.generate(user)
            return ApiResponse.success(user.toResponse(token))
        } ?: run {
            return ApiResponse.error(InvalidCredentialsError())
        }
    }

    @PutMapping("user")
    fun updateUser(
        @RequestBody userRequest: UserRequest? = null
    ): Any {
        if (userRequest == null) return ApiResponse.error(BadRequestError())
        return service.findByMobile(userRequest.mobile)?.let { dbUser ->
            val user = userRequest.toEntity()
            service.save(user.copy(id = dbUser.id))
        } ?: run {
            ApiResponse.error(BadRequestError(message = "کابری با این مشخصات یافت نشد!"))
        }

    }

    @GetMapping("user")
    fun getUser(
        @RequestHeader("Authorization") token: String?,
    ): Any? {
        return if (token.isNullOrEmpty()) ApiResponse.error(BadRequestError())
        else {
            val mobile = jwtService.extractMobile(token)
            if (mobile.isNullOrEmpty()) return ApiResponse.error(UnauthorizedError())
            else {
                service.findByMobile(mobile)?.let { dbUser ->
                    return ApiResponse.success(dbUser.toResponse(""))
                } ?: run {
                    ApiResponse.error(BadRequestError(message = "کابری با این مشخصات یافت نشد!"))
                }
            }
        }
    }

}