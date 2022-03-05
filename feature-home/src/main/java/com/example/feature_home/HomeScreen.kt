package com.example.feature_home

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    BackHandler(onBack = { homeViewModel.setEvent(event = HomeEvent.CloseApp) })

    val homeState = homeViewModel.viewState.collectAsState()
    val homeEffect = homeViewModel.effect


}