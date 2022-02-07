package com.inquisitor.domain.usecase

import com.inquisitor.data.repository.VideoRepository
import com.inquisitor.domain.di.IoDispatcher
import com.inquisitor.domain.mapper.mapToModel
import com.inquisitor.domain.model.VideoModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VideoUseCaseImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val videoRepository: VideoRepository
) : VideoUseCase {
    override suspend fun loadVideoListBySearchKey(
        searchKey: String,
        onSuccess: (List<VideoModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        videoRepository
            .loadVideoListBySearchKey(searchKey = searchKey)
            .map { mainVideoResponse ->
                mainVideoResponse.videoList?.mapToModel() ?: emptyList()
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