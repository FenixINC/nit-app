package com.inquisitor.data.repository

import com.inquisitor.data.network.response.pexels.MainVideoResponse
import kotlinx.coroutines.flow.Flow

interface VideoRepository {
    suspend fun loadVideoListBySearchKey(searchKey: String): Flow<MainVideoResponse>
}