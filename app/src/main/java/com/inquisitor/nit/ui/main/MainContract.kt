package com.inquisitor.nit.ui.main

import com.example.mobicatestapp.viewmodel.base.ViewEffect
import com.example.mobicatestapp.viewmodel.base.ViewEvent
import com.example.mobicatestapp.viewmodel.base.ViewState

data class MainState(
    val isLoading: Boolean = false
) : ViewState

sealed class MainEvent : ViewEvent {
    data class TopBar(
        val isShowTopBar: Boolean
    ) : MainEvent()
}

sealed class MainEffect : ViewEffect {

}