package com.inquisitor.domain.usecase

import com.inquisitor.domain.model.PhotoModel

interface PhotoUseCase {
    suspend fun loadPhotoListBySearchKey(
        searchKey: String,
        onSuccess: (List<PhotoModel>) -> Unit,
        onError: (Throwable) -> Unit
    )
}