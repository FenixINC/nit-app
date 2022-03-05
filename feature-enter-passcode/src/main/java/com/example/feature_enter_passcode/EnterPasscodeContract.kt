package com.example.feature_enter_passcode

import com.example.common_viewmodel.ViewEffect
import com.example.common_viewmodel.ViewEvent
import com.example.common_viewmodel.ViewState

sealed class EnterPasscodeEvent : ViewEvent {
    object OpenLoginScreen : EnterPasscodeEvent()
    data class Login(val passCode: String) : EnterPasscodeEvent()
}

sealed class EnterPasscodeState : ViewState {
    object Idle : EnterPasscodeState()
}

sealed class EnterPasscodeEffect : ViewEffect {
    data class Loading(val isLoading: Boolean) : EnterPasscodeEffect()
    data class Error(val errorMessage: String) : EnterPasscodeEffect()
}