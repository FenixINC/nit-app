package com.inquisitor.domain.usecase

import com.inquisitor.data.repository.PhotoRepository
import com.inquisitor.domain.di.IoDispatcher
import com.inquisitor.domain.mapper.mapToModel
import com.inquisitor.domain.model.PhotoModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PhotoUseCaseImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val photoRepository: PhotoRepository
) : PhotoUseCase {
    override suspend fun loadPhotoListBySearchKey(
        searchKey: String,
        onSuccess: (List<PhotoModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        photoRepository
            .loadPhotoListBySearchKey(searchKey = searchKey)
            .map { mainPhotoResponse ->
                mainPhotoResponse.photoList?.mapToModel() ?: emptyList()
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