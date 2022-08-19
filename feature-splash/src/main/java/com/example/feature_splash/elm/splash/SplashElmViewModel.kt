package com.example.feature_splash.elm.splash

import androidx.lifecycle.viewModelScope
import com.example.feature_splash.elm.cmd.SplashCmd
import com.example.feature_splash.elm.base.TeaViewModel
import com.example.feature_splash.elm.base.state
import com.example.navigation.NavigationConstants.ROUTE_HOME
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashElmViewModel @Inject constructor(
    navigator: Navigator,
    splashCommandHandler: SplashCmdHandler
) : TeaViewModel<SplashElmState, SplashCmd>(
    initialState = SplashElmState(isNavigateToHome = false),
    commandHandler = splashCommandHandler
), Navigator by navigator {
    init {
        viewModelScope.launch {
            state.collectLatest { splashState ->
                if (splashState.isNavigateToHome) {
                    navigator.navigate(route = ROUTE_HOME)
                }
            }
        }
    }
}