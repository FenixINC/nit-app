package com.inquisitor.data.repository

import com.inquisitor.data.network.response.pexels.MainPhotoResponse
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    suspend fun loadPhotoListBySearchKey(searchKey: String): Flow<MainPhotoResponse>
}