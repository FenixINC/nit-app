package com.example.feature_splash

import com.example.common_viewmodel.ViewEffect
import com.example.common_viewmodel.ViewEvent
import com.example.common_viewmodel.ViewState

sealed class SplashEvent : ViewEvent {
    object OpenLoginScreen: SplashEvent()
    object OpenHomeScreen: SplashEvent()
}

sealed class SplashState : ViewState {
    object Idle : SplashState()
}

sealed class SplashEffect : ViewEffect {

}