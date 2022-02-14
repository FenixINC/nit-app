package com.inquisitor.nit.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.inquisitor.nit.navigation.Navigator
import com.inquisitor.nit.navigation.NavigatorEvent
import com.inquisitor.nit.navigation.destination.SplashDestination
import com.inquisitor.nit.navigation.destination.addComposableDestinations
import com.inquisitor.nit.network_connection.CheckInternetConnection
import com.inquisitor.nit.network_connection.NetworkStatusResultState
import com.inquisitor.nit.ui.base.top_bar.NitTopBar
import com.inquisitor.nit.ui.resources.theme.NitappTheme
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
            val isShowToolbarState = remember { mutableStateOf(value = false) }

            NitappTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    Column(modifier = Modifier.fillMaxSize()) {
                        AnimatedVisibility(visible = isShowToolbarState.value) {
                            NitTopBar()
                        }

                        LaunchedEffect(navController) {
                            navigator.destinations.collectLatest { navigationEvent ->
                                when (navigationEvent) {
                                    is NavigatorEvent.CloseApp -> this@MainActivity.finish()
                                    is NavigatorEvent.NavigateUp -> navController.navigateUp()
                                    is NavigatorEvent.TopBar -> {
                                        isShowToolbarState.value = navigationEvent.isShowTopBar
                                    }
                                    is NavigatorEvent.Error -> {
                                        when (navigationEvent.throwable) {
                                            // TODO: show error
                                        }
                                    }
                                    is NavigatorEvent.InternetConnectionState -> {
                                        when (navigationEvent.networkStatusResultState) {
                                            is NetworkStatusResultState.Success -> {
                                                // TODO: success connect
                                                val s = ""
                                            }
                                            is NetworkStatusResultState.Error -> {
                                                // TODO: show internet connection error
                                                val e = ""
                                            }
                                        }
                                    }
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

                    /**
                     * Base logic
                     **/
                    CheckInternetConnection()
                }
            }
        }
    }
}