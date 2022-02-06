package com.inquisitor.domain.usecase

import com.inquisitor.domain.model.AssetModel
import com.inquisitor.domain.model.BundleModel
import com.inquisitor.domain.model.pexels.CollectionModel
import com.inquisitor.domain.model.pexels.PhotoModel

interface HomeUseCase {
    suspend fun loadFilmList(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    )

    suspend fun loadNftList(
        onSuccess: (List<BundleModel>) -> Unit,
        onError: (Throwable) -> Unit
    )

    suspend fun loadAssetList(
        onSuccess: (List<AssetModel>) -> Unit,
        onError: (Throwable) -> Unit
    )

    suspend fun loadCollectionList(
        onSuccess: (List<CollectionModel>) -> Unit,
        onError: (Throwable) -> Unit
    )

    suspend fun loadPhotoListBySearchKey(
        searchKey: String,
        onSuccess: (List<PhotoModel>) -> Unit,
        onError: (Throwable) -> Unit
    )
}