package com.sopt.carrot.data.profile

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestProfileDto(
    @SerialName("birthYear")
    val birthYear: Int,
    @SerialName("gender")
    val gender: Int,
    @SerialName("introduction")
    val introduction: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("phoneNumber")
    val phoneNumber: String
)

@Serializable
data class ResponseProfileDto(
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
        @SerialName("birthYear")
        val birthYear: Int,
        @SerialName("gender")
        val gender: Int,
        @SerialName("introduction")
        val introduction: String,
        @SerialName("name")
        val name: Any,
        @SerialName("phoneNumber")
        val phoneNumber: String
    )
}