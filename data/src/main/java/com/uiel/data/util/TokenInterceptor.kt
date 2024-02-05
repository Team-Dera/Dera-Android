package com.uiel.data.util

import com.uiel.data.api.DeraUrl
import com.uiel.data.storage.UserDataStorage
import okhttp3.Interceptor
import okhttp3.Response
import java.time.LocalDateTime
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val userDataStorage: UserDataStorage,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath

        val ignorePaths = listOf(
            DeraUrl.User.SignIn,
            DeraUrl.User.SignUp,
        )

        val accessExpireAt = userDataStorage.fetchAccessTokenExpiresAt()

        if (accessExpireAt.isNotBlank() && LocalDateTime.now()
                .isAfter(LocalDateTime.parse(accessExpireAt))
        ) {
            TODO("tokenReissue")
        }

        if (ignorePaths.contains(path)) {
            return chain.proceed(request)
        }

        val accessToken = userDataStorage.fetchAccessToken()
        return chain.proceed(
            request
                .newBuilder()
                .header("Authorization", "Bearer $accessToken")
                .build(),
        )
    }
}