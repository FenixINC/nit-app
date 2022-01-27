package com.inquisitor.feature_login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inquisitor.domain.usecase.LoginUseCase
import com.inquisitor.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator,
    private val loginUseCase: LoginUseCase
) : ViewModel(), Navigator by navigator {
    fun login() {
        viewModelScope.launch {
            loginUseCase.login(
                onSuccess = {

                },
                onError = {

                }
            )
        }
    }
}