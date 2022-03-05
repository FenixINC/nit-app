package com.example.common_ui.top_bar

import com.example.common_viewmodel.BaseViewModel
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NitTopBarViewModel @Inject constructor(
    private val navigator: Navigator
) : BaseViewModel<TopBarEvent, TopBarState, TopBarEffect>(), Navigator by navigator {

    override fun setInitialState() = TopBarState

    override fun handleEvents(event: TopBarEvent) {
        when (event) {
            is TopBarEvent.OpenProfile -> {
                openProfile()
            }
            is TopBarEvent.OpenMenu -> {
                openMenu()
            }
            is TopBarEvent.OpenMore -> {

            }
            is TopBarEvent.NavigateUp -> {
                onBack()
            }
        }
    }

    private fun openProfile() {

    }

    private fun openMenu() {

    }

    private fun onBack() {
        navigator.navigateUp()
    }
}