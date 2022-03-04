package com.inquisitor.nit.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.common_resources.background
import com.example.common_resources.background50Opacity
import com.example.navigation.destination.SplashDestination
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.inquisitor.nit.navigation.destination.addComposableDestinations
import com.inquisitor.nit.network_connection.CheckInternetConnection
import com.inquisitor.nit.ui.base.top_bar.NitTopBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(state = Lifecycle.State.CREATED) {
                mainViewModel.viewState.collectLatest { mainState ->
                    if (mainState.isComposeNavigation) {
                        setContent {
                            // TODO: fix calling systemUiController
                            val systemUiController = rememberSystemUiController()

                            SideEffect {
                                systemUiController.setStatusBarColor(color = Color.Transparent)
                            }

                            val isShowToolbarState = remember { mutableStateOf(value = false) }

//                            NitappTheme {
                            Surface(color = background50Opacity) {
                                val navController = rememberAnimatedNavController()

                                Column(modifier = Modifier.fillMaxSize()) {
                                    AnimatedVisibility(visible = isShowToolbarState.value) {
                                        NitTopBar()
                                    }

                                    LaunchedEffect(navController) {
                                        mainViewModel.effect.collectLatest { effect ->
                                            when (effect) {
                                                is MainEffect.CloseApp -> {
                                                    this@MainActivity.finish()
                                                }
                                                is MainEffect.TopBar -> {
                                                    isShowToolbarState.value =
                                                        effect.isShowToolbar
                                                }
                                                is MainEffect.NavigateUp -> {
                                                    navController.navigateUp()
                                                }
                                                is MainEffect.Error -> {
                                                    when (effect.throwable) {
                                                        // TODO: show error
                                                    }
                                                }
                                                is MainEffect.Navigate -> {
                                                    navController.navigate(
                                                        route = effect.destination,
                                                        builder = effect.builder
                                                    )
                                                }
                                                is MainEffect.InternetConnection -> {
                                                    when (effect.isSuccess) {
                                                        true -> {
                                                            // TODO: success connect
                                                        }
                                                        false -> {
                                                            // TODO: show internet connection error
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    AnimatedNavHost(
                                        navController = navController,
                                        startDestination = SplashDestination.route(),
                                        builder = {
                                            addComposableDestinations()
                                        },
                                        enterTransition = {
                                            slideIntoContainer(
                                                AnimatedContentScope.SlideDirection.Left,
                                                animationSpec = tween(200)
                                            )
                                        },
                                        exitTransition = {
                                            slideOutOfContainer(
                                                AnimatedContentScope.SlideDirection.Left,
                                                animationSpec = tween(200)
                                            )
                                        },
                                        popEnterTransition = {
                                            slideIntoContainer(
                                                AnimatedContentScope.SlideDirection.Right,
                                                animationSpec = tween(200)
                                            )
                                        },
                                        popExitTransition = {
                                            slideOutOfContainer(
                                                AnimatedContentScope.SlideDirection.Right,
                                                animationSpec = tween(200)
                                            )
                                        }
                                    )
                                }

                                /**
                                 * Base logic
                                 **/
                                CheckInternetConnection()
                            }
//                            }
                        }
                    } else {
//                        setContentView(R.layout.activity_main)
//
//                        val navHostFragment = supportFragmentManager
//                            .findFragmentById(R.id.nav_host) as NavHostFragment
//                        val navController = navHostFragment.navController
//
//                        navController.graph = navController.createGraph(
//                            startDestination = ProfileDestination.route(),
//                            builder = { addFragmentDestinations() }
//                        )
                    }
                }
            }
        }
    }
}