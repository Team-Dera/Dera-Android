package com.uiel.data.api

import com.uiel.data.model.signin.SignInRequest
import com.uiel.data.model.signin.SignInResponse
import com.uiel.data.model.signup.SignUpRequest
import com.uiel.data.model.signup.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST(DeraUrl.User.SignIn)
    suspend fun postSignIn(
        @Body request: SignInRequest
    ): SignInResponse

    @POST(DeraUrl.User.SignUp)
    suspend fun postSignUp(
        @Body request: SignUpRequest
    ): SignUpResponse
}