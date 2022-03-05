package com.example.feature_home.test_home

import com.example.common_viewmodel.ViewEffect
import com.example.common_viewmodel.ViewEvent
import com.example.common_viewmodel.ViewState
import com.inquisitor.domain.model.CollectionModel
import com.inquisitor.domain.model.PhotoModel
import com.inquisitor.domain.model.VideoModel

data class TestHomeState(
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

sealed class TestHomeEvent : ViewEvent {
    object CloseApp : TestHomeEvent()
    object LoadMedia : TestHomeEvent()
    data class OpenCollectionDetails(val collectionId: String) : TestHomeEvent()
}

sealed class TestHomeEffect : ViewEffect {
    data class Loading(val isLoading: Boolean = false) : TestHomeEffect()
}