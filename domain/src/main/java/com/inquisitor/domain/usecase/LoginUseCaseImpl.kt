package com.inquisitor.domain.usecase

import com.inquisitor.data.repository.LoginRepository
import com.inquisitor.di.qualifier.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val loginRepository: LoginRepository
) : LoginUseCase {
    override suspend fun login(
        username: String,
        password: String,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        loginRepository
            .login(username = username, password = password)
            .catch { throwable ->
                onError(throwable.localizedMessage ?: "")
            }
            .flowOn(context = dispatcher)
            .collect { result ->
                onSuccess(result)
            }
    }
}