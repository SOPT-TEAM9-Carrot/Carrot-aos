package com.sopt.carrot.data.page

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface PageService {
    @GET("/posts/{postId}")
    fun getPage(
        @Header("Authorization") Authorization: Int,
        @Path(value = "postId") postId: Long
    ): Call<PageResponse>

    @GET("/posts/list")
    fun getAlba(
        @Header("Authorization") Authorization: Int,
        @Query("size") size: Long
    ): Call<AlbaResponse>
}