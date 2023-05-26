package com.sopt.carrot.data.review

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface ReviewService {
    @GET("/employer/{userId}/reviews?size=10")
    fun getReviewList(
        @Header("Authorization") Authorization: String = "1",
        @Path(value = "userId") userId: Int = 3
    ): Call<ResponseReviewDto>
}