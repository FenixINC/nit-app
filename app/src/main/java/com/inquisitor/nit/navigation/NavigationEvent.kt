package com.inquisitor.nit.navigation

import androidx.navigation.NavOptionsBuilder

sealed class NavigatorEvent {
    object CloseApp : NavigatorEvent()

    object NavigateUp : NavigatorEvent()

    data class Error(
        val throwable: Throwable
    ) : NavigatorEvent()

    data class Directions(
        val destination: String,
        val builder: NavOptionsBuilder.() -> Unit
    ) : NavigatorEvent()
}