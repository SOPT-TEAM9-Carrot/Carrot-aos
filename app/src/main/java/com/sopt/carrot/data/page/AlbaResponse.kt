package com.sopt.carrot.data.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class AlbaResponse(
    @SerialName("status")
    val status: Integer,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val data: Detail
) {
    @kotlinx.serialization.Serializable
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