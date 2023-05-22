package com.sopt.carrot.data.review

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseReviewDto(
    @SerialName("data")
    val `data`: Data,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Int,
    @SerialName("success")
    val success: Boolean
) {
    @Serializable
    data class Data(
        @SerialName("degree")
        val degree: Double,
        @SerialName("imageUrl")
        val imageUrl: String,
        @SerialName("nickname")
        val nickname: String,
        @SerialName("reviews")
        val reviews: List<Review>,
        @SerialName("userId")
        val userId: Int
    ) {
        @Serializable
        data class Review(
            @SerialName("reviewerName")
            val reviewerName: String,
            @SerialName("imageUrl")
            val imageUrl: String,
            @SerialName("comment")
            val comment: String
        )
    }
}