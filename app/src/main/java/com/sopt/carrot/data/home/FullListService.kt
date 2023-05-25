package com.sopt.carrot.data.home

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface FullListService {
    @GET("/posts/list")
    fun getFullJobList(
        @Header("Authorization") Authorization: Int,
        @Query("size") size: Long
    ): Call<ResponseFullListDto>
}