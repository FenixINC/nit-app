package com.inquisitor.nit.ui.login

import androidx.lifecycle.viewModelScope
import com.inquisitor.domain.usecase.LoginUseCase
import com.inquisitor.nit.base.BaseViewModel
import com.inquisitor.nit.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator,
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginEvent, LoginState, LoginEffect>(), Navigator by navigator {

    override fun setInitialState() = LoginState.Loading()

    override fun handleEvents(event: LoginEvent) {
        when (event) {
            is LoginEvent.Login -> {
                login(username = event.username, password = event.password)
            }
        }
    }

    private fun login(
        username: String,
        password: String
    ) = viewModelScope.launch {
        setState {
            LoginState.Loading(isLoading = true)
        }

        loginUseCase.login(
            username = username,
            password = password,
            onSuccess = {
//                _loginState.value = _loginState.value.copy(
//                    isLoading = false,
//                    result = "SUCCESS"
//                )
            },
            onError = {
//                _loginState.value = _loginState.value.copy(
//                    isLoading = false,
//                    errorMessage = "ERROR"
//                )
            }
        )
    }
}