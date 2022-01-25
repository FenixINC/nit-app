package com.inquisitor.data.repository

import com.inquisitor.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(

) : LoginRepository {
    override suspend fun login(): Flow<String> = flow {
        emit(value = "")
    }
}