package com.example.feature_login

import com.example.common_viewmodel.BaseViewModel
import com.example.navigation.NavigationConstants.ROUTE_ENTER_PASSCODE
import com.example.navigation.Navigator
import com.example.navigation.top_bar_config.TopBarLoginConfig
import com.example.navigation.top_bar_config.TopBarProvider
import com.example.navigation.top_bar_config.TopBarType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator
) : BaseViewModel<LoginEvent, LoginState, LoginEffect>(), Navigator by navigator {

    init {
        navigator.topBar(
            topBarProvider = TopBarProvider(
                topBarType = TopBarType.LOGIN,
                topBarLoginConfig = TopBarLoginConfig(
                    iconLogo = R.drawable.ic_logo,
                    iconMore = R.drawable.ic_more
                )
            )
        )
        navigator.bottomBar(isShowBottomBar = false)
    }

    override fun setInitialState(): LoginState = LoginState.Idle

    override fun handleEvents(event: LoginEvent) {
        when (event) {
            is LoginEvent.CloseApp -> {
                navigator.onCloseApp()
            }
            is LoginEvent.OpenEnterPasscodeScreen -> {
                navigator.navigate(route = ROUTE_ENTER_PASSCODE)
            }
        }
    }
}