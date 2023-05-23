package com.sopt.carrot.data.home

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ResponseRecommendDto(
    @SerialName("status")
    val status: Integer,
    @SerialName("success")
    val success: Boolean,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: Detail
) {
    @Serializable
    data class Detail(
        @SerialName("nickname")
        val nickname: String,
        @SerialName("posts")
        val posts: List<Post>,
    ) {
        @Serializable
        data class Post(
            @SerialName("userId")
            val userId: Int,
            @SerialName("postId")
            val postId: Int,
            @SerialName("title")
            val title: String,
            @SerialName("image")
            val image: String,
            @SerialName("monthlyWage")
            val monthlyWage: Int,
        )

    }

}
