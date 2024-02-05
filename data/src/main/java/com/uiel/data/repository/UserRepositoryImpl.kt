package com.uiel.data.repository

import com.uiel.data.datasource.user.UserDataSource
import com.uiel.data.model.signin.SignInRequest
import com.uiel.data.model.signup.SignUpRequest
import com.uiel.data.storage.UserDataStorage
import com.uiel.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource,
    private val userDataStorage: UserDataStorage,
) : UserRepository {

    override suspend fun postSignIn(
        accountId: String,
        password: String,
    ) {
        userDataSource.postSignIn(
            request = SignInRequest(
                accountId = accountId,
                password = password,
            ),
        ).also {
            userDataStorage.setUserInfo(
                accessToken = it.accessToken,
                refreshToken = it.refreshToken,
                accessTokenExpiresAt = it.accessTokenExpiredAt,
                refreshTokenExpiresAt = it.refreshTokenExpiredAt,
            )
        }

    }

    override suspend fun postSignUp(
        userName: String,
        accountId: String,
        password: String,
    ) {
        userDataSource.postSignUp(
            request = SignUpRequest(
                userName = userName,
                accountId = accountId,
                password = password,
            ),
        ).also {
            userDataStorage.setUserInfo(
                accessToken = it.accessToken,
                refreshToken = it.refreshToken,
                accessTokenExpiresAt = it.accessTokenExpiredAt,
                refreshTokenExpiresAt = it.refreshTokenExpiredAt,
            )
        }
    }
}
