package com.sopt.carrot.data.home

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseFullListDto(
    @SerialName("status")
    val status: Integer,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val data: Detail
) {
    @Serializable
    data class Detail(
        @SerialName("posts")
        val posts: List<Post>
    ) {
        @Serializable
        data class Post(
            @SerialName("title")
            val title: String,
            @SerialName("image")
            val image: String,
            @SerialName("hourlyWage")
            val hourlyWage: Int
        )

    }
}