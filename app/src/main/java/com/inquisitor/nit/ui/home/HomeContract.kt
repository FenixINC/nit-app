package com.inquisitor.nit.ui.home

import com.example.mobicatestapp.viewmodel.base.ViewEffect
import com.example.mobicatestapp.viewmodel.base.ViewEvent
import com.example.mobicatestapp.viewmodel.base.ViewState
import com.inquisitor.domain.model.CollectionModel
import com.inquisitor.domain.model.PhotoModel
import com.inquisitor.domain.model.VideoModel

data class HomeState(
    val collectionList: List<CollectionModel>? = null,

    val recommendedPhotoList: List<PhotoModel>? = null,
    val recommendedVideoList: List<VideoModel>? = null,

    val animalsPhotoList: List<PhotoModel>? = null,
    val animalsVideoList: List<VideoModel>? = null,

    val naturePhotoList: List<PhotoModel>? = null,
    val natureVideoList: List<VideoModel>? = null,

    val trendsPhotoList: List<PhotoModel>? = null,
    val trendsVideoList: List<VideoModel>? = null
) : ViewState

sealed class HomeEvent : ViewEvent {
    object CloseApp : HomeEvent()
    object LoadMedia : HomeEvent()
    data class OpenCollectionDetails(val collectionId: String) : HomeEvent()
}

sealed class HomeEffect : ViewEffect {
    data class Loading(val isLoading: Boolean = false) : HomeEffect()
}