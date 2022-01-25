package com.inquisitor.nit.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.inquisitor.navigation.Navigator
import com.inquisitor.navigation.NavigatorEvent
import com.inquisitor.navigation.destination.SplashDestination
import com.inquisitor.nit.navigation.addComposableDestinations
import com.inquisitor.nit.ui.theme.NitappTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NitappTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    LaunchedEffect(navController) {
                        navigator.destinations.collectLatest { navigationEvent ->
                            when (navigationEvent) {
                                is NavigatorEvent.CloseApp -> this@MainActivity.finish()
                                is NavigatorEvent.NavigateUp -> navController.navigateUp()
                                is NavigatorEvent.Directions -> navController.navigate(
                                    navigationEvent.destination,
                                    navigationEvent.builder
                                )
                            }
                        }
                    }

                    NavHost(
                        navController = navController,
                        startDestination = SplashDestination.route(),
                        builder = {
                            addComposableDestinations()
                        }
                    )
                }
            }
        }
    }
}