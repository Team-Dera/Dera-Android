package com.uiel.data.util

import com.uiel.data.api.DeraUrl
import com.uiel.data.storage.UserDataStorage
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(
    private val userDataStorage: UserDataStorage,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath

        val ignorePaths = listOf(
            DeraUrl.User.SignIn,
            DeraUrl.User.SignUp,
        )

        if (ignorePaths.contains(path)) {
            return chain.proceed(request)
        }

        return chain.proceed(
            request
                .newBuilder()
                .header("Authorization", "Bearer ${userDataStorage.fetchAccessToken()}")
                .build(),
        )
    }
}