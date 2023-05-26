package com.sopt.carrot.data

import com.sopt.carrot.BuildConfig.API_SERVER_URL
import com.sopt.carrot.data.page.PageService
import com.sopt.carrot.data.review.ReviewService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiPool {
    val pageService = RetrofitPool.toApiServer.create(PageService::class.java)
    val reviewService = RetrofitPool.toApiServer.create<ReviewService>(ReviewService::class.java)
}

object RetrofitPool {
    val toApiServer by lazy {
        Retrofit.Builder()
            .baseUrl(API_SERVER_URL)
            .client(
                OkHttpClient.Builder().apply {
                    connectTimeout(10, TimeUnit.SECONDS)
                    writeTimeout(5, TimeUnit.SECONDS)
                    readTimeout(5, TimeUnit.SECONDS)
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}