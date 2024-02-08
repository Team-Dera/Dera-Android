package com.uiel.di

import com.uiel.data.api.UserApi
import com.uiel.data.util.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(
            if(BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            },
        )
    }

    @Provides
    @Singleton
    fun provideDefaultOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        tokenInterceptor: TokenInterceptor,
    ): OkHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
        .addInterceptor(tokenInterceptor).build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(com.uiel.data.BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideUserApi(
        retrofit: Retrofit,
    ): UserApi =
        retrofit.create(UserApi::class.java)

}
