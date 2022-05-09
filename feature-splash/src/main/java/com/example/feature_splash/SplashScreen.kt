package com.example.feature_splash

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_splash.elm.base.accept
import com.example.feature_splash.elm.base.state
import com.example.feature_splash.elm.msg.InitializeSplashMsg
import com.example.feature_splash.elm.splash.SplashElmViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SplashScreen(
    splashViewModel: SplashViewModel = hiltViewModel(),
    splashElmViewModel: SplashElmViewModel = hiltViewModel()
) {
    BackHandler(onBack = { splashViewModel.onCloseApp() })
    splashElmViewModel.accept(msg = InitializeSplashMsg())

//    LaunchedEffect(key1 = Unit) {
//        splashElmViewModel.state.collectLatest { splashElmState ->
//
//        }
//    }

//    LaunchedEffect(key1 = Unit) {
//        splashViewModel.setEvent(event = SplashEvent.OpenLoginScreen)
//    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = "Icon logo")
    }
}