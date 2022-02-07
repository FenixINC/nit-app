package com.inquisitor.nit.navigation.destination

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.inquisitor.nit.constants.StringConstants.EMPTY_TEXT
import com.inquisitor.nit.navigation.NavigationConstants.ARG_COLLECTION_ID
import com.inquisitor.nit.navigation.NavigationDestination
import com.inquisitor.nit.ui.collection_details.CollectionDetailsScreen
import com.inquisitor.nit.ui.home.HomeScreen
import com.inquisitor.nit.ui.login.LoginScreen
import com.inquisitor.nit.ui.splash.SplashScreen

private fun getComposableDestinations(): Map<NavigationDestination, @Composable (NavBackStackEntry) -> Unit> =
    mapOf(
        SplashDestination to { SplashScreen() },
        LoginDestination to { LoginScreen() },
        HomeDestination to { HomeScreen() },
        CollectionDetailsDestination to { navBackStackEntry ->
            val collectionId = navBackStackEntry
                .arguments
                ?.getString(ARG_COLLECTION_ID)
                ?: EMPTY_TEXT

            CollectionDetailsScreen(collectionId = collectionId)
        }
    )

fun NavGraphBuilder.addComposableDestinations() {
    getComposableDestinations().forEach { entry ->
        val destination = entry.key

        composable(
            destination.route(),
            destination.arguments,
            destination.deepLinks
        ) { navBackStackEntry ->
            entry.value(navBackStackEntry)
        }
    }
}