package com.inquisitor.nit.ui.home

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen() {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    BackHandler(onBack = { homeViewModel.onCloseApp() })

    val homeState = homeViewModel.viewState.collectAsState()
    val homeEffect = homeViewModel.effect

    homeViewModel.setEvent(event = HomeEvent.LoadNftList)

    HomeScreenContent(
        homeState = homeState.value,
        homeEffect = homeEffect,
        homeViewModel = homeViewModel
    )
}

@Composable
private fun HomeScreenContent(
    homeState: HomeState,
    homeEffect: Flow<HomeEffect>,
    homeViewModel: HomeViewModel
) {
    LaunchedEffect(key1 = Unit) {
        homeEffect.collectLatest { effect ->
            when (effect) {
                is HomeEffect.Loading -> {

                }
                is HomeEffect.Error -> {
                    homeViewModel.setEvent(
                        event = HomeEvent.Error(errorMessage = effect.errorMessage)
                    )
                }
            }

        }
    }

    when (homeState) {
        is HomeState.ShowNftList -> {

        }
    }
}