package com.sopt.carrot.data.page

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PageService {
    @GET("/posts/{postId}")
    fun getPage(
        @Path(value = "postId") postId: Long
    ): Call<PageResponse>

}