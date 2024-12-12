package com.divar.spring.core.image.dto

import com.divar.spring.core.image.entity.Image

data class ImageResponse(
    val path: String
)

fun Image.toResponse(): ImageResponse {
    return ImageResponse(path = path)
}