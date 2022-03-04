package com.inquisitor.nit.ui.main

import android.os.Build
import androidx.lifecycle.viewModelScope
import com.example.navigation.Navigator
import com.example.navigation.NavigatorEvent
import com.inquisitor.nit.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val navigator: Navigator
) : BaseViewModel<MainEvent, MainState, MainEffect>(), Navigator by navigator {

    init {
        handleNavigation()
        checkAndroidSdkVersion()
    }

    override fun setInitialState() = MainState()

    override fun handleEvents(event: MainEvent) {
        when (event) {
            is MainEvent.CheckAndroidVersion -> {
                checkAndroidSdkVersion()
            }
            is MainEvent.TopBar -> {

            }
        }
    }

    private fun checkAndroidSdkVersion() {
        setState {
            copy(
                isLoading = false,
                isComposeNavigation = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
            )
        }
    }

    private fun handleNavigation() {
        viewModelScope.launch {
            navigator.destinations.collectLatest { navigationEvent ->
                when (navigationEvent) {
                    is NavigatorEvent.CloseApp -> setEffect { MainEffect.CloseApp }
                    is NavigatorEvent.NavigateUp -> setEffect { MainEffect.NavigateUp }
                    is NavigatorEvent.TopBar -> {
                        setEffect {
                            MainEffect.TopBar(isShowToolbar = navigationEvent.isShowTopBar)
                        }
                    }
                    is NavigatorEvent.Error -> {
                        // TODO: show error
                    }
//                    is NavigatorEvent.InternetConnectionState -> {
//                        when (navigationEvent.networkStatusResultState) {
//                            is NetworkStatusResultState.Success -> {
//                                setEffect { MainEffect.InternetConnection(isSuccess = true) }
//                            }
//                            is NetworkStatusResultState.Error -> {
//                                setEffect { MainEffect.InternetConnection(isSuccess = false) }
//                            }
//                        }
//                    }
                    is NavigatorEvent.Directions -> {
                        setEffect {
                            MainEffect.Navigate(
                                destination = navigationEvent.destination,
                                builder = navigationEvent.builder
                            )
                        }
                    }
                }
            }
        }
    }
}