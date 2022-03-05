package com.example.common_ui.bottom_bar

import com.example.common_viewmodel.ViewEffect
import com.example.common_viewmodel.ViewEvent
import com.example.common_viewmodel.ViewState

sealed class BottomBarEvent : ViewEvent {
    data class Navigate(val route: String) : BottomBarEvent()
}

object BottomBarState : ViewState
object BottomBarEffect : ViewEffect