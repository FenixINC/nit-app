package com.inquisitor.domain.usecase

import com.inquisitor.data.repository.HomeRepository
import com.inquisitor.di.qualifier.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val homeRepository: HomeRepository
) : HomeUseCase {
    override suspend fun loadFilmList(
        onSuccess: () -> Unit,
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
}