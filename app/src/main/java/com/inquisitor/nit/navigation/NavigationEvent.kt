package com.inquisitor.nit.navigation

import androidx.navigation.NavOptionsBuilder
import com.inquisitor.nit.network_connection.NetworkStatusResultState

sealed class NavigatorEvent {
    object CloseApp : NavigatorEvent()

    object NavigateUp : NavigatorEvent()

    data class TopBar(
        val isShowTopBar: Boolean = false,
        val isShowBackButton: Boolean = false
    ) : NavigatorEvent()

    data class Error(
        val throwable: Throwable
    ) : NavigatorEvent()

    data class InternetConnectionState(
        val networkStatusResultState: NetworkStatusResultState
    ) : NavigatorEvent()

    data class Directions(
        val destination: String,
        val builder: NavOptionsBuilder.() -> Unit
    ) : NavigatorEvent()
}