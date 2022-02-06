package com.inquisitor.data.repository

import com.inquisitor.data.network.response.anime.FilmResponse
import com.inquisitor.data.network.response.open_sea_nft.MainAssetResponse
import com.inquisitor.data.network.response.open_sea_nft.MainBundleResponse
import com.inquisitor.data.network.response.pexels.MainCollectionResponse
import com.inquisitor.data.network.response.pexels.MainPhotoResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun loadFilmList(): Flow<List<FilmResponse>>
    suspend fun loadNftAsset(): Flow<MainBundleResponse>
    suspend fun loadAssetList(): Flow<MainAssetResponse>

    suspend fun loadCollectionList(): Flow<MainCollectionResponse>
    suspend fun loadPhotoListBySearchKey(searchKey: String): Flow<MainPhotoResponse>
}