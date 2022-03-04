package com.example.feature_login

import com.example.common_viewmodel.BaseViewModel
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator
) : BaseViewModel<LoginEvent, LoginState, LoginEffect>(), Navigator by navigator {

    override fun setInitialState(): LoginState = LoginState.Idle

    override fun handleEvents(event: LoginEvent) {
        when (event) {
            is LoginEvent.CloseApp -> {
                navigator.onCloseApp()
            }
        }
    }
}