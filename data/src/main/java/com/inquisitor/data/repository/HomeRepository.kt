package com.inquisitor.data.repository

import com.inquisitor.data.network.response.anime.FilmResponse
import com.inquisitor.data.network.response.open_sea_nft.BundleResponse
import com.inquisitor.data.network.response.open_sea_nft.MainBundleResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun loadFilmList(): Flow<List<FilmResponse>>
    suspend fun loadNftAsset(): Flow<MainBundleResponse>
}