package com.divar.spring.utils.response

import org.springframework.http.HttpStatus


interface ApiError {
    val httpStatus: HttpStatus
    val message: String
}

data class NotFoundError(
    override val httpStatus: HttpStatus = HttpStatus.NOT_FOUND,
    override val message: String = "اوه! چیزی پیدا نشد."
) : ApiError

data class InvalidCredentialsError(
    override val httpStatus: HttpStatus = HttpStatus.UNAUTHORIZED,
    override val message: String = "نام کاربری یا رمز عبور اشتباهه! یه بار دیگه شانستو امتحان کن."
) : ApiError


data class ServerError(
    override val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    override val message: String = "اوپس! سرور ترکید!"
) : ApiError

data class BadRequestError(
    override val httpStatus: HttpStatus = HttpStatus.BAD_REQUEST,
    override val message: String = "درخواستت یه مشکلی داره، لطفاً چکش کن."
) : ApiError

data class UnauthorizedError(
    override val httpStatus: HttpStatus = HttpStatus.UNAUTHORIZED,
    override val message: String = "اجازه دسترسی نداری، لطفاً وارد شو."
) : ApiError

data class ForbiddenError(
    override val httpStatus: HttpStatus = HttpStatus.FORBIDDEN,
    override val message: String = "اینجا ورود ممنوعه! دسترسی نداری."
) : ApiError

data class ConflictError(
    override val httpStatus: HttpStatus = HttpStatus.CONFLICT,
    override val message: String = "یه تداخلی پیش اومده، دوباره تلاش کن."
) : ApiError

data class GoneError(
    override val httpStatus: HttpStatus = HttpStatus.GONE,
    override val message: String = "این مورد دیگه نیست، حذف شده."
) : ApiError

data class UnsupportedMediaTypeError(
    override val httpStatus: HttpStatus = HttpStatus.UNSUPPORTED_MEDIA_TYPE,
    override val message: String = "فرمت فایل ساپورت نمیشه، یه چیز دیگه بفرست."
) : ApiError

data class TooManyRequestsError(
    override val httpStatus: HttpStatus = HttpStatus.TOO_MANY_REQUESTS,
    override val message: String = "خیلی درخواست دادی، یه کم صبر کن."
) : ApiError

data class ServiceUnavailableError(
    override val httpStatus: HttpStatus = HttpStatus.SERVICE_UNAVAILABLE,
    override val message: String = "سرویس فعلاً خوابیده، بعداً بیا."
) : ApiError
