package com.inquisitor.domain.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(): Flow<String>
}