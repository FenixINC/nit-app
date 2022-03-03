package com.inquisitor.nit.ui.home

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.inquisitor.domain.model.CollectionModel
import com.inquisitor.nit.R
import com.inquisitor.nit.ui.resources.space16dp
import com.inquisitor.nit.ui.resources.space8dp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    BackHandler(onBack = { homeViewModel.setEvent(event = HomeEvent.CloseApp) })

    val homeState = homeViewModel.viewState.collectAsState()
    val homeEffect = homeViewModel.effect

    Column(modifier = Modifier.fillMaxSize()) {
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

    // TODO: temporary
//    homeViewModel.setEvent(event = HomeEvent.LoadMedia)
}

@Composable
private fun HomeScreenContent(
    homeState: HomeState,
    homeEffect: Flow<HomeEffect>,
    homeViewModel: HomeViewModel
) {
    var isAnimated by remember { mutableStateOf(value = false) }
    val colorState = remember { Animatable(Color.DarkGray) }

    var isRotated by rememberSaveable { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (isRotated) {
            360F
        } else {
            0f
        },
        animationSpec = tween(durationMillis = 2500)
    )

    LaunchedEffect(key1 = isAnimated) {
        colorState.animateTo(
            targetValue = if (isAnimated) {
                Color.Green
            } else {
                Color.Red
            },
            animationSpec = tween(durationMillis = 500)
        )
    }

    LaunchedEffect(key1 = Unit) {
        homeEffect.collectLatest { effect ->
            when (effect) {
                is HomeEffect.Loading -> {

                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentPadding = PaddingValues(horizontal = space16dp),
            horizontalArrangement = Arrangement.spacedBy(space = space8dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(
                items = homeState.collectionList ?: listOf(
                    CollectionModel(
                        id = "1",
                        title = "ERROR"
                    )
                ),
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

        // TODO: Testing animations
        Button(
            onClick = {
                isAnimated = !isAnimated
                isRotated = !isRotated
            },
            modifier = Modifier
                .size(width = 100.dp, height = 50.dp)
                .background(color = Color.Blue)
        ) {

        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 50.dp)
        )

        Box(
            modifier = Modifier
                .rotate(rotationAngle)
                .size(width = 100.dp, height = 100.dp)
                .background(colorState.value)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 50.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.item1),
            contentDescription = "fan",
            modifier = Modifier
                .rotate(rotationAngle)
                .size(150.dp)
        )
    }
}