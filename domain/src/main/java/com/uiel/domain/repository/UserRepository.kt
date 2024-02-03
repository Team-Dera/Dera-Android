package com.uiel.domain.repository

interface UserRepository {
    suspend fun postSignIn(
        accountId: String,
        password: String,
    )

    suspend fun postSignUp(
        userName: String,
        accountId: String,
        password: String,
    )
}