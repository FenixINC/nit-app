package com.inquisitor.feature_home

import com.inquisitor.domain.usecase.HomeUseCase

class FakeHomeUseCase : HomeUseCase {
    override suspend fun loadFilmList(
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        val success = "Success"
        val error = "Error"

        onSuccess(success)
//        onError(error)
    }
}