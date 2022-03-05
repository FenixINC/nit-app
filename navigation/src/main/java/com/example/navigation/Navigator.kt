package com.example.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.Flow

interface Navigator {
    val destinations: Flow<NavigatorEvent>

    fun onCloseApp(): Boolean

    fun onError(throwable: Throwable): Boolean

    fun topBar(
        isShowTopBar: Boolean = false,
        isShowBackButton: Boolean = false,
        isShowIconProfile: Boolean = false,
        isShowIconMore: Boolean = false
    ): Boolean

    fun navigateUp(): Boolean

    fun navigate(
        route: String,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true }
    ): Boolean
}