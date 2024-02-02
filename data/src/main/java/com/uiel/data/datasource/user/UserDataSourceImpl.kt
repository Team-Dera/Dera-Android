package com.uiel.data.datasource.user

import com.uiel.data.api.UserApi
import com.uiel.data.model.signin.SignInRequest
import com.uiel.data.model.signin.SignInResponse
import com.uiel.data.model.signup.SignUpRequest
import com.uiel.data.model.signup.SignUpResponse
import com.uiel.data.util.ExceptionHandler

class UserDataSourceImpl(
    private val userApi: UserApi,
) : UserDataSource {
    override suspend fun postSignUp(
        request: SignUpRequest,
    ) = ExceptionHandler<SignUpResponse>().httpRequest {
        userApi.postSignUp(request = request)
    }.sendRequest()

    override suspend fun postSignIn(
        request: SignInRequest,
    ) = ExceptionHandler<SignInResponse>().httpRequest {
        userApi.postSignIn(request = request)
    }.sendRequest()
}
