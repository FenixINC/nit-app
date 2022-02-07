package com.inquisitor.data.repository

import com.inquisitor.data.network.api.NitApi
import com.inquisitor.data.network.response.pexels.CollectionDetailsResponse
import com.inquisitor.data.network.response.pexels.MainCollectionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CollectionRepositoryImpl @Inject constructor(
    private val nitApi: NitApi
) : CollectionRepository {

    override suspend fun loadCollectionList(): Flow<MainCollectionResponse> =
        flow {
            emit(value = nitApi.loadCollectionList())
        }

    override suspend fun loadCollectionDetails(collectionId: String): Flow<CollectionDetailsResponse> =
        flow {
            emit(value = nitApi.loadCollectionDetails(collectionId = collectionId))
        }
}