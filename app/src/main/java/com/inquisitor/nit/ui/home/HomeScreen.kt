package com.inquisitor.nit.ui.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.inquisitor.nit.ui.base.Toolbar
import com.inquisitor.nit.ui.resources.space16dp
import com.inquisitor.nit.ui.resources.space8dp
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

    homeViewModel.setEvent(event = HomeEvent.LoadCollectionList)
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

    if (!homeState.collectionList.isNullOrEmpty()) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentPadding = PaddingValues(horizontal = space16dp, vertical = space8dp),
            horizontalArrangement = Arrangement.spacedBy(space = space8dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(
                items = homeState.collectionList,
                key = { collectionModel -> collectionModel.id }
            ) { collectionModel ->
                CollectionRow(
                    collectionModel = collectionModel,
                    onCollectionClick = { collection ->
                        homeViewModel.setEvent(
                            event = HomeEvent.OpenCollectionDetails(collectionId = collection.id)
                        )
                    }
                )
            }
        }
    }
}