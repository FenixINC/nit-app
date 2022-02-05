package com.inquisitor.domain.usecase

import com.inquisitor.domain.model.AssetModel
import com.inquisitor.domain.model.BundleModel

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
}