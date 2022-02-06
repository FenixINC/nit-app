package com.inquisitor.nit.ui.base

import com.example.mobicatestapp.viewmodel.base.ViewEffect
import com.example.mobicatestapp.viewmodel.base.ViewEvent
import com.example.mobicatestapp.viewmodel.base.ViewState

object ToolbarState : ViewState

sealed class ToolbarEvent : ViewEvent {
    object OpenProfile : ToolbarEvent()
    object OpenMenu : ToolbarEvent()
    object NavigateUp : ToolbarEvent()
}

sealed class ToolbarEffect : ViewEffect {

}