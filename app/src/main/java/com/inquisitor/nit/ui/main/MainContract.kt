package com.inquisitor.nit.ui.main

import androidx.navigation.NavOptionsBuilder
import com.example.mobicatestapp.viewmodel.base.ViewEffect
import com.example.mobicatestapp.viewmodel.base.ViewEvent
import com.example.mobicatestapp.viewmodel.base.ViewState
import com.example.navigation.top_bar_config.TopBarProvider

data class MainState(
    val isLoading: Boolean = false,
    val isComposeNavigation: Boolean = false
) : ViewState

sealed class MainEvent : ViewEvent {
    object CheckAndroidVersion : MainEvent()

    data class TopBar(
        val isShowTopBar: Boolean
    ) : MainEvent()
}

sealed class MainEffect : ViewEffect {
    data class TopBar(val topBarProvider: TopBarProvider) : MainEffect()
    data class Error(val throwable: Throwable) : MainEffect()
    data class Navigate(
        val destination: String,
        val builder: NavOptionsBuilder.() -> Unit
    ) : MainEffect()

    object NavigateUp : MainEffect()
    object CloseApp : MainEffect()

    data class InternetConnection(val isSuccess: Boolean) : MainEffect()
}