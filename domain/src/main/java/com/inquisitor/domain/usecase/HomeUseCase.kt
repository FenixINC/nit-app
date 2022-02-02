package com.inquisitor.domain.usecase

interface HomeUseCase {
    suspend fun loadFilmList(onSuccess: (String) -> Unit, onError: (String) -> Unit)
}