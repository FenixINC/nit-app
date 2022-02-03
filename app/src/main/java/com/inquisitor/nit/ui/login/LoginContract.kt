package com.inquisitor.nit.ui.login

import com.example.mobicatestapp.viewmodel.base.ViewEffect
import com.example.mobicatestapp.viewmodel.base.ViewEvent
import com.example.mobicatestapp.viewmodel.base.ViewState

sealed class LoginState : ViewState {
    data class Loading(val isLoading: Boolean? = false) : LoginState()
    data class Result(val result: String? = null) : LoginState()
    data class Error(val errorMessage: String? = null) : LoginState()
}

sealed class LoginEvent : ViewEvent {
    data class Login(
        val username: String,
        val password: String
    ) : LoginEvent()
}

sealed class LoginEffect : ViewEffect {

}