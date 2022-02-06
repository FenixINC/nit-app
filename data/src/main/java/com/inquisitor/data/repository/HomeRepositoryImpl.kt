package com.inquisitor.data.repository

import com.inquisitor.data.network.api.NitApi
import com.inquisitor.data.network.response.anime.FilmResponse
import com.inquisitor.data.network.response.pexels.MainCollectionResponse
import com.inquisitor.data.network.response.pexels.MainPhotoResponse
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

    override suspend fun loadCollectionList(): Flow<MainCollectionResponse> =
        flow {
            emit(value = nitApi.loadCollectionList())
        }

    override suspend fun loadPhotoListBySearchKey(searchKey: String): Flow<MainPhotoResponse> =
        flow {
            emit(value = nitApi.loadPhotoListBySearchKey(searchKey = searchKey))
        }
}