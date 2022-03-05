package com.example.navigation

import androidx.navigation.NavOptionsBuilder

sealed class NavigatorEvent {
    object CloseApp : NavigatorEvent()

    object NavigateUp : NavigatorEvent()

    data class TopBar(
        val isShowTopBar: Boolean = false,
        val isShowBackButton: Boolean = false,
        val isShowIconProfile: Boolean = false,
        val isShowIconMore: Boolean = false
    ) : NavigatorEvent()

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