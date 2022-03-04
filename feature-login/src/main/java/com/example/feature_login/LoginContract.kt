package com.example.feature_login

import com.example.common_viewmodel.ViewEffect
import com.example.common_viewmodel.ViewEvent
import com.example.common_viewmodel.ViewState

sealed class LoginEvent : ViewEvent {
    object CloseApp : LoginEvent()
}

sealed class LoginState : ViewState {
    object Idle : LoginState()
}

sealed class LoginEffect : ViewEffect {

}