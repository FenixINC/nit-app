package com.inquisitor.domain.usecase

import com.inquisitor.domain.model.VideoModel

interface VideoUseCase {
    suspend fun loadVideoListBySearchKey(
        searchKey: String,
        onSuccess: (List<VideoModel>) -> Unit,
        onError: (Throwable) -> Unit
    )
}