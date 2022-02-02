package com.inquisitor.feature_home

import com.inquisitor.navigation.NavigatorImpl
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(
            navigator = NavigatorImpl(),
            homeUseCase = FakeHomeUseCase()
        )
    }

    @Test
    fun loadFilmList() {
        homeViewModel.loadFilmList()
    }
}