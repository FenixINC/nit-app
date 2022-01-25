package com.inquisitor.feature_splash.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inquisitor.di.qualifier.IoDispatcher
import com.inquisitor.navigation.NavigationConstants.ROUTE_LOGIN
import com.inquisitor.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigator: Navigator,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel(), Navigator by navigator {
    fun openLoginScreen() {
        viewModelScope.launch {
            delay(timeMillis = 2500L)
            navigator.navigate(route = ROUTE_LOGIN)
        }
    }
}