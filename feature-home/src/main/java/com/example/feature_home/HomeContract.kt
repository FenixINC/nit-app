package com.example.feature_home

import com.example.common_viewmodel.ViewEffect
import com.example.common_viewmodel.ViewEvent
import com.example.common_viewmodel.ViewState

sealed class HomeEvent : ViewEvent {
    object CloseApp : HomeEvent()
    object LoadData : HomeEvent()
}

data class HomeState(
    val idle: String = ""
) : ViewState

sealed class HomeEffect : ViewEffect {

}