package com.inquisitor.data.repository

import com.inquisitor.data.network.api.NitApi
import com.inquisitor.data.network.response.pexels.MainVideoResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VideoRepositoryImpl @Inject constructor(
    private val nitApi: NitApi
) : VideoRepository {
    override suspend fun loadVideoListBySearchKey(searchKey: String): Flow<MainVideoResponse> =
        flow {
            emit(value = nitApi.loadVideoListBySearchKey(searchKey = searchKey))
        }
}