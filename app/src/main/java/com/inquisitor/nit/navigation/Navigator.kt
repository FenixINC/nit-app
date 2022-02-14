package com.inquisitor.nit.navigation

import androidx.navigation.NavOptionsBuilder
import com.inquisitor.nit.network_connection.NetworkStatusResultState
import kotlinx.coroutines.flow.Flow

interface Navigator {
    val destinations: Flow<NavigatorEvent>

    fun onCloseApp(): Boolean

    fun onError(throwable: Throwable): Boolean

    fun topBar(
        isShowTopBar: Boolean = false,
        isSHowBackButton: Boolean = false
    ): Boolean

    fun setInternetConnectionState(networkStatusResultState: NetworkStatusResultState): Boolean

    fun navigateUp(): Boolean

    fun navigate(
        route: String,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = true }
    ): Boolean
}