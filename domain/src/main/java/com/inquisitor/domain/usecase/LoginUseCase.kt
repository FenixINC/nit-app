package com.inquisitor.domain.usecase

interface LoginUseCase {
    suspend fun login(
        username: String,
        password: String,
        onSuccess: (String) -> Unit = {},
        onError: (String) -> Unit = {}
    )
}