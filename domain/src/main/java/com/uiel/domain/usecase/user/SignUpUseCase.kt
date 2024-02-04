package com.uiel.domain.usecase.user

import com.uiel.domain.repository.UserRepository

class SignUpUseCase(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(
        userName: String,
        accountId: String,
        password: String,
    ) = runCatching {
        userRepository.postSignUp(
            userName = userName,
            accountId = accountId,
            password = password,
        )
    }
}