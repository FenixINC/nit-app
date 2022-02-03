package com.inquisitor.nit.ui.home

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen() {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    BackHandler(onBack = { homeViewModel.onCloseApp() })

    homeViewModel.loadFilmList()
}