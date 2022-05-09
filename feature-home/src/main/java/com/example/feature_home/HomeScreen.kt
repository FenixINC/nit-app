package com.example.feature_home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common_resources.textYourBalance
import com.example.common_resources.white
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.material.placeholder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    BackHandler(onBack = { homeViewModel.setEvent(event = HomeEvent.CloseApp) })

    val homeState = homeViewModel.viewState.collectAsState()
    val homeEffect = homeViewModel.effect

    val полиця_1 = "Green"

    HomeContent(
        homeViewModel = homeViewModel,
        homeState = homeState.value,
        homeEffect = homeEffect
    )

    homeViewModel.setEvent(event = HomeEvent.LoadData)
}

@Composable
private fun HomeContent(
    homeViewModel: HomeViewModel,
    homeState: HomeState,
    homeEffect: Flow<HomeEffect>
) {
    LaunchedEffect(key1 = Unit) {
        homeEffect.collectLatest { homeEffect ->

        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentPadding = PaddingValues(horizontal = 20.dp),
    ) {
        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 24.dp)
            )
        }

        item {
            YourBalanceView(
                balance = homeState.homeModel.balanceModel.balance,
                isLoading = homeState.isLoading
            )
        }

        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 24.dp)
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = homeState.homeModel.cardList,
                    key = { cardModel -> cardModel.id }
                ) { cardModel ->
                    CardItemView(
                        cardModel = cardModel,
                        isLoading = homeState.isLoading
                    )
                }
            }
        }

        items(items = homeState.homeModel.expandableList, key = { it.id }) { expandModel ->
            ExpandableItemView(
                model = expandModel,
                isExpanded = homeState.expandMap.contains(key = expandModel.expandType),
                onClick = {
                    homeViewModel.setEvent(
                        event = HomeEvent.ExpandCardClick(
                            expandModel = expandModel
                        )
                    )
                }
            )
        }
    }
}

@Composable
private fun YourBalanceView(balance: String, isLoading: Boolean) {
    Text(
        text = textYourBalance,
        color = white,
        fontSize = 16.sp,
        modifier = Modifier
            .wrapContentSize()
            .placeholder(
                visible = isLoading,
                color = Color.Gray,
                shape = RoundedCornerShape(4.dp),
                highlight = PlaceholderHighlight.fade(
                    highlightColor = Color.White,
                )
            )
    )

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(
                height = if (isLoading) {
                    20.dp
                } else {
                    0.dp
                }
            )
    )

    Text(
        text = balance,
        color = white,
        fontSize = 24.sp,
        modifier = Modifier
            .wrapContentSize()
            .placeholder(
                visible = isLoading,
                color = Color.Gray,
                shape = RoundedCornerShape(4.dp),
                highlight = PlaceholderHighlight.fade(
                    highlightColor = Color.White,
                )
            )
    )
}