package com.inquisitor.nit.ui.base.top_bar

import com.example.navigation.Navigator
import com.inquisitor.nit.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NitTopBarViewModel @Inject constructor(
    private val navigator: Navigator
) : BaseViewModel<ToolbarEvent, ToolbarState, ToolbarEffect>(), Navigator by navigator {

    override fun setInitialState() = ToolbarState

    override fun handleEvents(event: ToolbarEvent) {
        when (event) {
            is ToolbarEvent.OpenProfile -> {
                openProfile()
            }
            is ToolbarEvent.OpenMenu -> {
                openMenu()
            }
            is ToolbarEvent.OpenMore -> {

            }
            is ToolbarEvent.NavigateUp -> {
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