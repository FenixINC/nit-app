package com.inquisitor.data.repository

import com.inquisitor.data.network.response.pexels.CollectionDetailsResponse
import com.inquisitor.data.network.response.pexels.MainCollectionResponse
import kotlinx.coroutines.flow.Flow

interface CollectionRepository {
    suspend fun loadCollectionList(): Flow<MainCollectionResponse>
    suspend fun loadCollectionDetails(collectionId: String): Flow<CollectionDetailsResponse>
}