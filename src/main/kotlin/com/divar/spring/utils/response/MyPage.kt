package com.divar.spring.utils.response

import org.springframework.data.domain.Page

data class MyPage<T>(
    val content: T,
    val totalPage: Int,
    val totalElements: Long,
    val isFirst: Boolean,
    val isLast: Boolean,
)

fun <T> Page<T>.toMyPage(content: List<*> = this.content): MyPage<*> {
    return MyPage(
        content = content,
        totalPage = this.totalPages,
        totalElements = this.totalElements,
        isFirst = this.isFirst,
        isLast = this.isLast
    )
}