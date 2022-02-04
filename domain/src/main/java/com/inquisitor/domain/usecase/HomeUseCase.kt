package com.inquisitor.domain.usecase

import com.inquisitor.data.network.error_handling.HttpException
import com.inquisitor.domain.model.BundleModel

interface HomeUseCase {
    suspend fun loadFilmList(onSuccess: (String) -> Unit, onError: (String) -> Unit)
    suspend fun loadNftList(
        onSuccess: (List<BundleModel>) -> Unit,
        onError: (HttpException) -> Unit
    )
}