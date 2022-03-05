package com.example.common_ui.top_bar

import com.example.common_viewmodel.ViewEffect
import com.example.common_viewmodel.ViewEvent
import com.example.common_viewmodel.ViewState

object ToolbarState : ViewState

sealed class ToolbarEvent : ViewEvent {
    object OpenProfile : ToolbarEvent()
    object OpenMenu : ToolbarEvent()
    object OpenMore : ToolbarEvent()
    object NavigateUp : ToolbarEvent()
}

sealed class ToolbarEffect : ViewEffect {

}