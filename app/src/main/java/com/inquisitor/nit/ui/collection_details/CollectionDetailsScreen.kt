package com.inquisitor.nit.ui.collection_details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.inquisitor.nit.ui.base.top_bar.NitTopBar
import com.inquisitor.nit.ui.resources.space16dp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CollectionDetailsScreen(
    collectionId: String,
    collectionDetailsViewModel: CollectionDetailsViewModel = hiltViewModel()
) {
    BackHandler(onBack = { collectionDetailsViewModel.setEvent(event = CollectionDetailsEvent.NavigateUp) })

    val collectionDetailsState = collectionDetailsViewModel.viewState.collectAsState()
    val collectionDetailsEffect = collectionDetailsViewModel.effect

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {
            NitTopBar(topBarState = mutableStateOf(value = true))
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = space16dp)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CollectionDetailsContent(
                collectionDetailsState = collectionDetailsState.value,
                collectionDetailsEffect = collectionDetailsEffect,
                collectionDetailsViewModel = collectionDetailsViewModel
            )
        }
    }

    collectionDetailsViewModel.setEvent(
        event = CollectionDetailsEvent.LoadCollectionDetails(
            collectionId = collectionId
        )
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CollectionDetailsContent(
    collectionDetailsState: CollectionDetailsState,
    collectionDetailsEffect: Flow<CollectionDetailsEffect>,
    collectionDetailsViewModel: CollectionDetailsViewModel
) {
    LaunchedEffect(key1 = Unit) {
        collectionDetailsEffect.collectLatest { effect ->
            when (effect) {

            }
        }
    }

    val mediaList = collectionDetailsState.result?.mediaList
    val mediaListSize = mediaList?.size ?: 0
    if (mediaList != null && mediaListSize > 0) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(count = 3),
            content = {
                items(count = mediaListSize) { index ->
                    MediaRow(mediaModel = mediaList[index])
                }
            }
        )
    }
}