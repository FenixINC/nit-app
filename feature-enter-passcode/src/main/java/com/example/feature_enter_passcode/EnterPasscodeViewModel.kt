package com.example.feature_enter_passcode

import androidx.lifecycle.viewModelScope
import com.example.common_viewmodel.BaseViewModel
import com.example.navigation.NavigationConstants.ROUTE_HOME
import com.example.navigation.NavigationConstants.ROUTE_LOGIN
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EnterPasscodeViewModel @Inject constructor(
    private val navigator: Navigator
) : BaseViewModel<EnterPasscodeEvent, EnterPasscodeState, EnterPasscodeEffect>(),
    Navigator by navigator {

    init {
        navigator.topBar(isShowTopBar = true, isShowIconMore = true)
    }

    override fun setInitialState(): EnterPasscodeState = EnterPasscodeState.Idle

    override fun handleEvents(event: EnterPasscodeEvent) {
        when (event) {
            is EnterPasscodeEvent.OpenLoginScreen -> {
                navigator.navigate(route = ROUTE_LOGIN)
            }
            is EnterPasscodeEvent.Login -> {
                login(passCode = event.passCode)
            }
        }
    }

    private fun login(passCode: String) {
        viewModelScope.launch {
            // TODO: fake delay to simulate network; delete later
            delay(timeMillis = 1000L)

            setEffect {
                EnterPasscodeEffect.Loading(isLoading = true)
            }

            if (passCode == "1234") {
                setEffect {
                    EnterPasscodeEffect.Loading(isLoading = false)
                }
                navigator.navigate(route = ROUTE_HOME)
            } else {
                setEffect {
                    EnterPasscodeEffect.Loading(isLoading = false)
                }
                setEffect {
                    EnterPasscodeEffect.Error(errorMessage = "Wrong pin, Please retry!")
                }
            }
        }
    }
}