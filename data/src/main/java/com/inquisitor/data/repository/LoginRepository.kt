package com.inquisitor.data.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(): Flow<String>
}