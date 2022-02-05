package com.inquisitor.data.repository

import com.inquisitor.data.network.response.anime.FilmResponse
import com.inquisitor.data.network.response.open_sea_nft.MainAssetResponse
import com.inquisitor.data.network.response.open_sea_nft.MainBundleResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun loadFilmList(): Flow<List<FilmResponse>>
    suspend fun loadNftAsset(): Flow<MainBundleResponse>
    suspend fun loadAssetList(): Flow<MainAssetResponse>
}