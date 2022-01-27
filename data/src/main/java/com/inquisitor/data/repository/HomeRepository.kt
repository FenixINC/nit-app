package com.inquisitor.data.repository

import com.inquisitor.data.network.response.FilmResponse
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun loadFilmList(): Flow<List<FilmResponse>>
}