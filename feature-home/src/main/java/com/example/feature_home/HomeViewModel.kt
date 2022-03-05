package com.example.feature_home

import androidx.lifecycle.viewModelScope
import com.example.common_viewmodel.BaseViewModel
import com.example.navigation.Navigator
import com.example.navigation.top_bar_config.TopBarHomeConfig
import com.example.navigation.top_bar_config.TopBarProvider
import com.example.navigation.top_bar_config.TopBarType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator
) : BaseViewModel<HomeEvent, HomeState, HomeEffect>(), Navigator by navigator {

    init {
        navigator.topBar(
            topBarProvider = TopBarProvider(
                topBarType = TopBarType.HOME,
                topBarHomeConfig = TopBarHomeConfig(
                    iconProfile = R.drawable.image_profile,
                    iconLogo = R.drawable.ic_logo
                )
            )
        )
    }

    override fun setInitialState(): HomeState = HomeState()

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            is HomeEvent.CloseApp -> {
                navigator.onCloseApp()
            }
            is HomeEvent.LoadData -> {
                loadFakeData()
            }
        }
    }

    private fun loadFakeData() {
        viewModelScope.launch {

        }
    }
}