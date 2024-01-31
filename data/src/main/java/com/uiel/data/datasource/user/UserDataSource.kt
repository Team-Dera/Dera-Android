package com.uiel.data.datasource.user

import com.uiel.data.model.signin.SignInRequest
import com.uiel.data.model.signin.SignInResponse
import com.uiel.data.model.signup.SignUpRequest
import com.uiel.data.model.signup.SignUpResponse

interface UserDataSource {
    suspend fun postSignUp(request: SignUpRequest): SignUpResponse
    suspend fun postSignIn(request: SignInRequest): SignInResponse
}