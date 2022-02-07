package com.inquisitor.domain.usecase

import com.inquisitor.data.repository.CollectionRepository
import com.inquisitor.domain.di.IoDispatcher
import com.inquisitor.domain.mapper.mapToModel
import com.inquisitor.domain.model.CollectionDetailsModel
import com.inquisitor.domain.model.CollectionModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CollectionUseCaseImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val collectionRepository: CollectionRepository
) : CollectionUseCase {

    override suspend fun loadCollectionList(
        onSuccess: (List<CollectionModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        collectionRepository
            .loadCollectionList()
            .map { mainCollectionResponse ->
                mainCollectionResponse.collectionList?.mapToModel()
            }
            .flowOn(context = ioDispatcher)
            .catch { throwable ->
                onError(throwable)
            }
            .collect { result ->
                onSuccess(result ?: emptyList())
            }
    }

    override suspend fun loadCollectionDetails(
        collectionId: String,
        onSuccess: (CollectionDetailsModel) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        collectionRepository
            .loadCollectionDetails(collectionId = collectionId)
            .map { collectionDetailsResponse ->
                collectionDetailsResponse.mapToModel()
            }
            .flowOn(context = ioDispatcher)
            .catch { throwable ->
                onError(throwable)
            }
            .collect { result ->
                onSuccess(result)
            }
    }
}