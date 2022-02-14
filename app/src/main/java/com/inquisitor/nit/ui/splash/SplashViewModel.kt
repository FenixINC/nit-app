package com.inquisitor.nit.ui.splash

import androidx.lifecycle.viewModelScope
import com.inquisitor.nit.base.BaseViewModel
import com.inquisitor.nit.navigation.NavigationConstants.ROUTE_HOME
import com.inquisitor.nit.navigation.NavigationConstants.ROUTE_LOGIN
import com.inquisitor.nit.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigator: Navigator
) : BaseViewModel<SplashEvent, SplashState, SplashEffect>(), Navigator by navigator {

    override fun setInitialState() = SplashState.Idle

    override fun handleEvents(event: SplashEvent) {
        when (event) {
            is SplashEvent.OpenLoginScreen -> {
                viewModelScope.launch {
                    delay(timeMillis = 2500L)
                    navigator.navigate(route = ROUTE_LOGIN)
                }
            }
            is SplashEvent.OpenHomeScreen -> {
                viewModelScope.launch {
                    delay(timeMillis = 2500L)
                    navigator.navigate(route = ROUTE_HOME)
                }
            }
        }
    }

}