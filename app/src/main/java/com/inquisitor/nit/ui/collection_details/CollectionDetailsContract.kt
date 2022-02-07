package com.inquisitor.nit.ui.collection_details

import com.example.mobicatestapp.viewmodel.base.ViewEffect
import com.example.mobicatestapp.viewmodel.base.ViewEvent
import com.example.mobicatestapp.viewmodel.base.ViewState
import com.inquisitor.domain.model.CollectionDetailsModel

data class CollectionDetailsState(
    val result: CollectionDetailsModel? = null
) : ViewState

sealed class CollectionDetailsEvent : ViewEvent {
    object NavigateUp : CollectionDetailsEvent()
    data class LoadCollectionDetails(val collectionId: String) : CollectionDetailsEvent()
}

sealed class CollectionDetailsEffect : ViewEffect {

}