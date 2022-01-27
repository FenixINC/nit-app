package com.inquisitor.domain.usecase

interface HomeUseCase {
    suspend fun loadFilmList(onSuccess: () -> Unit, onError: (String) -> Unit)
}