package com.inquisitor.nit.ui.base.top_bar

import androidx.lifecycle.viewModelScope
import com.example.navigation.Navigator
import com.inquisitor.nit.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
            is ToolbarEvent.NavigateUp -> {
                onBack()
            }
        }
    }

    private fun openProfile() {
        viewModelScope.launch {

        }
    }

    private fun openMenu() {
        viewModelScope.launch {

        }
    }

    private fun onBack() {
        viewModelScope.launch {
            navigator.navigateUp()
        }
    }
}