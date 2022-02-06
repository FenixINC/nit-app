package com.inquisitor.nit.ui.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.inquisitor.nit.ui.base.Toolbar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen() {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    BackHandler(onBack = { homeViewModel.onCloseApp() })

    val homeState = homeViewModel.viewState.collectAsState()
    val homeEffect = homeViewModel.effect

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {
            Toolbar()
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            HomeScreenContent(
                homeState = homeState.value,
                homeEffect = homeEffect,
                homeViewModel = homeViewModel
            )
        }
    }

    homeViewModel.setEvent(event = HomeEvent.LoadPhotoList)
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
            }
        }
    }
}