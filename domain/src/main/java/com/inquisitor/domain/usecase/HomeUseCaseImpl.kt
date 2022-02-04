package com.inquisitor.domain.usecase

import com.inquisitor.data.network.error_handling.HttpException
import com.inquisitor.data.repository.HomeRepository
import com.inquisitor.domain.di.IoDispatcher
import com.inquisitor.domain.mapper.mapToModel
import com.inquisitor.domain.model.BundleModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val homeRepository: HomeRepository
) : HomeUseCase {

    override suspend fun loadFilmList(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        homeRepository
            .loadFilmList()
            .flowOn(context = dispatcher)
            .catch {
                val e = it
            }
            .collect {
                val s = it
            }
    }

    override suspend fun loadNftList(
        onSuccess: (List<BundleModel>) -> Unit,
        onError: (HttpException) -> Unit
    ) {
        homeRepository
            .loadNftAsset()
            .flowOn(context = dispatcher)
            .map { mainBundleResponse ->
                mainBundleResponse.mapToModel()
            }
            .flowOn(context = dispatcher)
            .catch { throwable ->
                val e = throwable
            }
            .collect { result ->
                onSuccess(result.bundleList ?: emptyList())
            }
    }
}