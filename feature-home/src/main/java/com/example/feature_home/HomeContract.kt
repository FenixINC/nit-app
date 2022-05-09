package com.example.feature_home

import com.example.common_viewmodel.ViewEffect
import com.example.common_viewmodel.ViewEvent
import com.example.common_viewmodel.ViewState

sealed class HomeEvent : ViewEvent {
    object CloseApp : HomeEvent()
    object LoadData : HomeEvent()
    data class ExpandCardClick(val expandModel: Expandable) : HomeEvent()
}

data class HomeState(
    val isLoading: Boolean = true,
    val homeModel: HomeModel = HomeModel(),
    val expandMap: Map<ExpandType, List<Expandable>> = emptyMap()
) : ViewState

sealed class HomeEffect : ViewEffect {
    data class Error(val errorMessage: String) : HomeEffect()
}