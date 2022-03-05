package com.example.common_ui.bottom_bar

import com.example.common_viewmodel.BaseViewModel
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NitBottomBarViewModel @Inject constructor(
    private val navigator: Navigator
) : BaseViewModel<BottomBarEvent, BottomBarState, BottomBarEffect>(), Navigator by navigator {

    override fun setInitialState(): BottomBarState = BottomBarState

    override fun handleEvents(event: BottomBarEvent) {
        when (event) {
            is BottomBarEvent.Navigate -> {
                navigator.navigate(
                    route = event.route,
                    builder = {
                        popUpTo(event.route)
                        launchSingleTop = true
                        restoreState = true
                    }
                )
            }
        }
    }
}