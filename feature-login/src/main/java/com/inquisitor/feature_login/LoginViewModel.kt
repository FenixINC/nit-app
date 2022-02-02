package com.inquisitor.feature_login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inquisitor.domain.usecase.LoginUseCase
import com.inquisitor.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator,
    private val loginUseCase: LoginUseCase
) : ViewModel(), Navigator by navigator {

    private val _loginState = MutableStateFlow(value = LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    fun login(
        username: String,
        password: String
    ) = viewModelScope.launch {
        _loginState.value = _loginState.value.copy(isLoading = true)

        loginUseCase.login(
            username = username,
            password = password,
            onSuccess = {
                _loginState.value = _loginState.value.copy(
                    isLoading = false,
                    result = "SUCCESS"
                )
            },
            onError = {
                _loginState.value = _loginState.value.copy(
                    isLoading = false,
                    errorMessage = "ERROR"
                )
            }
        )
    }
}