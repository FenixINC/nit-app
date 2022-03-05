package com.example.navigation

import androidx.navigation.NavOptionsBuilder
import com.example.navigation.top_bar_config.TopBarProvider
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorImpl @Inject constructor() : Navigator {
    private val navigationEvents = Channel<NavigatorEvent>()

    override val destinations = navigationEvents.receiveAsFlow()

    override fun onCloseApp(): Boolean =
        navigationEvents.trySend(element = NavigatorEvent.CloseApp).isSuccess

    override fun onError(throwable: Throwable): Boolean =
        navigationEvents.trySend(element = NavigatorEvent.Error(throwable = throwable)).isSuccess

    override fun topBar(
        topBarProvider: TopBarProvider
    ) = navigationEvents.trySend(
        element = NavigatorEvent.TopBar(
            topBarProvider = topBarProvider
        )
    ).isSuccess

    override fun bottomBar(isShowBottomBar: Boolean): Boolean =
        navigationEvents.trySend(
            element = NavigatorEvent.BottomBar(isShowBottomBar = isShowBottomBar)
        ).isSuccess

    override fun navigateUp(): Boolean =
        navigationEvents.trySend(element = NavigatorEvent.NavigateUp).isSuccess

    override fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit): Boolean =
        navigationEvents.trySend(element = NavigatorEvent.Directions(route, builder)).isSuccess
}