package com.inquisitor.domain

import com.inquisitor.data.repository.HomeRepository
import org.junit.Test
import org.mockito.kotlin.mock

class HomeUseCaseTest {

    val homeRepository = mock<HomeRepository>()

    @Test
    suspend fun `return real data from user repository`() {
//        Mockito.`when`(homeRepository.loadFilmList()).thenReturn()
    }

}