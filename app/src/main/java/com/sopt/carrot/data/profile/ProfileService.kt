package com.sopt.carrot.data.profile

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface ProfileService {
    @Headers("Authorization: 1")
    @POST("/users/profile")
    fun apply(
        @Body request: RequestProfileDto
    ): Call<ResponseProfileDto>
}