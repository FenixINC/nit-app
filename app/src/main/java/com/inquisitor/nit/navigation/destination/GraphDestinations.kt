package com.inquisitor.nit.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import com.example.feature_home.HomeScreen
import com.example.feature_login.LoginScreen
import com.example.feature_splash.SplashScreen
import com.example.navigation.NavigationDestination
import com.example.navigation.destination.HomeDestination
import com.example.navigation.destination.LoginDestination
import com.example.navigation.destination.SplashDestination
import com.google.accompanist.navigation.animation.composable

private fun getComposableDestinations(): Map<NavigationDestination, @Composable (NavBackStackEntry) -> Unit> =
    mapOf(
        SplashDestination to { SplashScreen() },
        LoginDestination to { LoginScreen() },
        HomeDestination to { HomeScreen() },
//        CollectionDetailsDestination to { navBackStackEntry ->
//            val collectionId = navBackStackEntry
//                .arguments
//                ?.getString(ARG_COLLECTION_ID)
//                ?: EMPTY_TEXT
//
//            CollectionDetailsScreen(collectionId = collectionId)
//        }
    )

private fun getFragmentDestinations(): Map<NavigationDestination, (NavBackStackEntry) -> Unit> =
    mapOf(
//        ProfileDestination to { ProfileFragment() }
    )

@OptIn(ExperimentalAnimationApi::class)
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

fun NavGraphBuilder.addFragmentDestinations() {
    getFragmentDestinations().forEach { entry ->
        val destination = entry.key

//        when (destination) {
//            is ProfileDestination -> {
//                fragment<ProfileFragment>(route = destination.route()) {
//                    destination.route()
//                    destination.arguments
//                    destination.deepLinks
//                }
//            }
//        }
    }
}