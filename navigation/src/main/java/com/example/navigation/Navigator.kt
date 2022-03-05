package com.example.navigation

import androidx.navigation.NavOptionsBuilder
import com.example.navigation.top_bar_config.TopBarProvider
import kotlinx.coroutines.flow.Flow

interface Navigator {
    val destinations: Flow<NavigatorEvent>

    fun onCloseApp(): Boolean

    fun onError(throwable: Throwable): Boolean

    fun topBar(topBarProvider: TopBarProvider = TopBarProvider()): Boolean

    fun bottomBar(isShowBottomBar: Boolean = true): Boolean

    fun navigateUp(): Boolean

    fun navigate(
        route: String,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true }
    ): Boolean
}