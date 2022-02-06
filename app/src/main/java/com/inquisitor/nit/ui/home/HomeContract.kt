package com.inquisitor.nit.ui.home

import com.example.mobicatestapp.viewmodel.base.ViewEffect
import com.example.mobicatestapp.viewmodel.base.ViewEvent
import com.example.mobicatestapp.viewmodel.base.ViewState
import com.inquisitor.domain.model.CollectionModel

data class HomeState(
    val collectionList: List<CollectionModel>? = null
) : ViewState

sealed class HomeEvent : ViewEvent {
    object LoadCollectionList : HomeEvent()
    object LoadPhotoList : HomeEvent()
    data class OpenCollectionDetails(val collectionId: String) : HomeEvent()
}

sealed class HomeEffect : ViewEffect {
    data class Loading(val isLoading: Boolean = false) : HomeEffect()
}