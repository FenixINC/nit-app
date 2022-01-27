package com.inquisitor.domain.usecase

interface LoginUseCase {
    suspend fun login(onSuccess: (String) -> Unit, onError: (String) -> Unit)
}