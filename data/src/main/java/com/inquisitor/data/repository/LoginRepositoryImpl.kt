package com.inquisitor.data.repository

import com.inquisitor.data.network.api.NitApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(
    private val nitApi: NitApi
) : LoginRepository {
    override suspend fun login(
        username: String,
        password: String
    ): Flow<String> = flow {
        emit(value = nitApi.login(username = username, password = password))
    }
}