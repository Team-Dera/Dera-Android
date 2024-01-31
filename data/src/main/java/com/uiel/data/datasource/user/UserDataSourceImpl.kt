package com.uiel.data.datasource.user

import com.uiel.data.api.UserApi
import com.uiel.data.model.signin.SignInRequest
import com.uiel.data.model.signin.SignInResponse
import com.uiel.data.model.signup.SignUpRequest
import com.uiel.data.model.signup.SignUpResponse

class UserDataSourceImpl(
    private val userApi: UserApi,
) : UserDataSource {
    override suspend fun postSignUp(request: SignUpRequest): SignUpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun postSignIn(request: SignInRequest): SignInResponse {
        TODO("Not yet implemented")
    }
}