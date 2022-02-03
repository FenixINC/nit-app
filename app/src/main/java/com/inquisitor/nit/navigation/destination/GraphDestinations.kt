package com.inquisitor.nit.navigation.destination

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.inquisitor.nit.navigation.NavigationDestination
import com.inquisitor.nit.ui.home.HomeScreen
import com.inquisitor.nit.ui.login.LoginScreen
import com.inquisitor.nit.ui.splash.SplashScreen

private val composableDestinations: Map<NavigationDestination, @Composable () -> Unit> = mapOf(
    SplashDestination to { SplashScreen() },
    LoginDestination to { LoginScreen() },
    HomeDestination to { HomeScreen() }
)

fun NavGraphBuilder.addComposableDestinations() {
    composableDestinations.forEach { entry ->
        val destination = entry.key

        composable(destination.route(), destination.arguments, destination.deepLinks) {
            entry.value()
        }
    }
}