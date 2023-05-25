package com.sopt.carrot.data.review

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path



interface ReviewService {
    @Headers("Authorization: 1") // 정적 헤더 설정
    @GET("/employer/{userId}/reviews?size=10")
    fun getReviewList(
        @Path(value = "userId") userId: Long //userId 받아올준비 완료
    ): Call<ResponseReviewDto>
}