package com.inquisitor.data.repository

import com.inquisitor.data.network.api.NitApi
import com.inquisitor.data.network.response.pexels.MainPhotoResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepositoryImpl @Inject constructor(
    private val nitApi: NitApi
) : PhotoRepository {
    override suspend fun loadPhotoListBySearchKey(searchKey: String): Flow<MainPhotoResponse> =
        flow {
            emit(value = nitApi.loadPhotoListBySearchKey(searchKey = searchKey))
        }
}