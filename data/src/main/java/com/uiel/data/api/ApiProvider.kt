package com.uiel.data.api

import com.uiel.data.util.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiProvider {

    private val retrofit: Retrofit?= null

    private fun getLoggingInterceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)

    private fun getRetrofit(
        tokenInterceptor: TokenInterceptor,
    ) : Retrofit {
        return retrofit ?: Retrofit.Builder().baseUrl("").client(
            OkHttpClient.Builder().addInterceptor(tokenInterceptor)
                .addInterceptor(getLoggingInterceptor()).build(),
        ).addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun getUserApi(tokenInterceptor: TokenInterceptor): UserApi {
        return getRetrofit(tokenInterceptor).create(UserApi::class.java)
    }
}