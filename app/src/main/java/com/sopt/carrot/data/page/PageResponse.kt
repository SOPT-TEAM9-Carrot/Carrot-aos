package com.sopt.carrot.data.page

import kotlinx.serialization.Serializable

@Serializable
data class PageResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Detail
) {
    @Serializable
    data class Detail(
        val image: String,
        val categories: List<String>,
        val title: String,
        val hourlyWage: Int,
        val content: String,
        val address: String,
    )
}