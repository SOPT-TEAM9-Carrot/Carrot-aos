package com.sopt.carrot.data

import com.sopt.carrot.BuildConfig.API_SERVER_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiPool {
    // TODO : 구성한 Api Service interface 들을 retrofit 을 통해 create 해주세요
    // ex
    // val loginService = RetrofitPool.toApiServer.create<LoginService>()
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