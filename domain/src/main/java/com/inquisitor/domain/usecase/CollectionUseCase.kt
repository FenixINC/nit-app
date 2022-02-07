package com.inquisitor.domain.usecase

import com.inquisitor.domain.model.CollectionDetailsModel
import com.inquisitor.domain.model.CollectionModel

interface CollectionUseCase {
    suspend fun loadCollectionList(
        onSuccess: (List<CollectionModel>) -> Unit,
        onError: (Throwable) -> Unit
    )

    suspend fun loadCollectionDetails(
        collectionId: String,
        onSuccess: (CollectionDetailsModel) -> Unit,
        onError: (Throwable) -> Unit
    )
}