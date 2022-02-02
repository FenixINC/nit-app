package com.inquisitor.domain

import com.inquisitor.data.network.response.FilmResponse
import com.inquisitor.data.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class HomeUseCaseTest {

    val homeRepository = mock<HomeRepository>()

    @Test
    suspend fun `return real data from user repository`() {
//        Mockito.`when`(homeRepository.loadFilmList()).thenReturn()
    }

}