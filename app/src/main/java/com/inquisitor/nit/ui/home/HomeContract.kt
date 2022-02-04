package com.inquisitor.nit.ui.home

import com.example.mobicatestapp.viewmodel.base.ViewEffect
import com.example.mobicatestapp.viewmodel.base.ViewEvent
import com.example.mobicatestapp.viewmodel.base.ViewState
import com.inquisitor.data.network.response.open_sea_nft.BundleResponse

sealed class HomeState : ViewState {
    object Idle : HomeState()
    data class ShowNftList(val nftList: List<BundleResponse>? = emptyList()) : HomeState()
}

sealed class HomeEvent : ViewEvent {
    object LoadNftList : HomeEvent()
    data class Error(val errorMessage: String) : HomeEvent()
}

sealed class HomeEffect : ViewEffect {
    data class Error(val errorMessage: String) : HomeEffect()
    data class Loading(val isLoading: Boolean = false) : HomeEffect()
}