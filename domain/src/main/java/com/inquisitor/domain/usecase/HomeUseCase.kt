package com.inquisitor.domain.usecase

import com.inquisitor.domain.model.CollectionModel
import com.inquisitor.domain.model.PhotoModel

interface HomeUseCase {
    suspend fun loadFilmList(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    )
}