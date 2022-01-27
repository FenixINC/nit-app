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
    override suspend fun login(): Flow<String> = flow { nitApi.login() }
}