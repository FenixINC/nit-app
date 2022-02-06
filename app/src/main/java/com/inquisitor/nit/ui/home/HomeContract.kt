package com.inquisitor.nit.ui.home

import com.example.mobicatestapp.viewmodel.base.ViewEffect
import com.example.mobicatestapp.viewmodel.base.ViewEvent
import com.example.mobicatestapp.viewmodel.base.ViewState
import com.inquisitor.domain.model.AssetModel
import com.inquisitor.domain.model.BundleModel

data class HomeState(
    val isLoading: Boolean? = false,
    val nftList: List<BundleModel>? = emptyList(),
    val assetList: List<AssetModel>? = emptyList()
) : ViewState

sealed class HomeEvent : ViewEvent {
    object LoadPhotoList : HomeEvent()
    data class Error(val errorMessage: String) : HomeEvent()
}

sealed class HomeEffect : ViewEffect {
    data class Loading(val isLoading: Boolean = false) : HomeEffect()
}