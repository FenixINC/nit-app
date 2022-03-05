package com.example.common_ui.top_bar

import com.example.common_viewmodel.ViewEffect
import com.example.common_viewmodel.ViewEvent
import com.example.common_viewmodel.ViewState

object TopBarState : ViewState

sealed class TopBarEvent : ViewEvent {
    object OpenProfile : TopBarEvent()
    object OpenMenu : TopBarEvent()
    object OpenMore : TopBarEvent()
    object NavigateUp : TopBarEvent()
}

sealed class TopBarEffect : ViewEffect {

}