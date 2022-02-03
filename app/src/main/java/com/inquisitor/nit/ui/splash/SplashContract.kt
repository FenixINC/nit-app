package com.inquisitor.nit.ui.splash

import com.example.mobicatestapp.viewmodel.base.ViewEffect
import com.example.mobicatestapp.viewmodel.base.ViewEvent
import com.example.mobicatestapp.viewmodel.base.ViewState

sealed class SplashState: ViewState {
    object Idle: SplashState()
}

sealed class SplashEvent: ViewEvent {
    object OpenLoginScreen: SplashEvent()
    object OpenHomeScreen: SplashEvent()
}

sealed class SplashEffect: ViewEffect {

}