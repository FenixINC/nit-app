package com.example.feature_home

import androidx.lifecycle.viewModelScope
import com.example.common_viewmodel.BaseViewModel
import com.example.navigation.Navigator
import com.example.navigation.top_bar_config.TopBarHomeConfig
import com.example.navigation.top_bar_config.TopBarProvider
import com.example.navigation.top_bar_config.TopBarType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
        navigator.bottomBar(isShowBottomBar = true)
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
            is HomeEvent.ExpandCardClick -> {
                onExpandCardClick(cardId = event.expandModel.id)
            }
        }
    }

    private fun loadFakeData() {
        viewModelScope.launch {
            kotlin.runCatching {
                // delay form network imitation
                delay(timeMillis = 3500L)
                getFakeHomeData()
            }.onSuccess { homeModel ->
                setExpandCardList(homeModel = homeModel)
            }.onFailure { throwable ->
                navigator.onError(throwable = throwable)
            }
        }
    }

    private fun setExpandCardList(homeModel: HomeModel) {
        viewModelScope.launch(context = Dispatchers.Default) {
            val expandMap = homeModel.expandableList.groupBy { it.expandType }

            setState {
                copy(
                    isLoading = false,
                    homeModel = homeModel,
                    expandMap = expandMap
                )
            }
        }
    }

    private fun onExpandCardClick(cardId: String) {

    }
}