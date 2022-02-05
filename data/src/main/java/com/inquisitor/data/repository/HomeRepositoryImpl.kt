package com.inquisitor.data.repository

import com.inquisitor.data.network.api.NitApi
import com.inquisitor.data.network.response.anime.FilmResponse
import com.inquisitor.data.network.response.open_sea_nft.BundleResponse
import com.inquisitor.data.network.response.open_sea_nft.MainAssetResponse
import com.inquisitor.data.network.response.open_sea_nft.MainBundleResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val nitApi: NitApi
) : HomeRepository {
    override suspend fun loadFilmList(): Flow<List<FilmResponse>> =
        flow {
            emit(value = nitApi.loadFilmList())
        }

    override suspend fun loadNftAsset(): Flow<MainBundleResponse> =
        flow {
            emit(value = nitApi.loadNftAsset())
        }

    override suspend fun loadAssetList(): Flow<MainAssetResponse> =
        flow {
            emit(value = nitApi.loadAssetList())
        }
}