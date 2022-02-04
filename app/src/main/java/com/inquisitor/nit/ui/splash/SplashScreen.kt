package com.inquisitor.nit.ui.splash

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SplashScreen() {
    val splashViewModel = hiltViewModel<SplashViewModel>()
    BackHandler(onBack = { splashViewModel.onCloseApp() })

    LaunchedEffect(key1 = Unit) {
        splashViewModel.setEvent(event = SplashEvent.OpenHomeScreen)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SPLASH SCREEN")
    }
}