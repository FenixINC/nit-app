package com.example.navigation

import androidx.navigation.NavOptionsBuilder
import com.example.navigation.top_bar_config.TopBarProvider

sealed class NavigatorEvent {
    object CloseApp : NavigatorEvent()

    object NavigateUp : NavigatorEvent()

    data class TopBar(val topBarProvider: TopBarProvider) : NavigatorEvent()

    data class Error(
        val throwable: Throwable
    ) : NavigatorEvent()

//    data class InternetConnectionState(
//        val networkStatusResultState: NetworkStatusResultState
//    ) : NavigatorEvent()

    data class Directions(
        val destination: String,
        val builder: NavOptionsBuilder.() -> Unit
    ) : NavigatorEvent()
}