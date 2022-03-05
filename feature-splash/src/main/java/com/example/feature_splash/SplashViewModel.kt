package com.example.feature_splash

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
class SplashViewModel @Inject constructor(
    private val navigator: Navigator
) : BaseViewModel<SplashEvent, SplashState, SplashEffect>(), Navigator by navigator {

    init {
        navigator.bottomBar(isShowBottomBar = false)
    }

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