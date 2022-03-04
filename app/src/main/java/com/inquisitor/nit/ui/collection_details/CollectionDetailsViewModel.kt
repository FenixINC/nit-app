package com.inquisitor.nit.ui.collection_details

import androidx.lifecycle.viewModelScope
import com.example.navigation.Navigator
import com.inquisitor.domain.usecase.CollectionUseCase
import com.inquisitor.nit.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollectionDetailsViewModel @Inject constructor(
    private val navigator: Navigator,
    private val collectionUseCase: CollectionUseCase
) : BaseViewModel<CollectionDetailsEvent, CollectionDetailsState, CollectionDetailsEffect>(),
    Navigator by navigator {

    override fun setInitialState() = CollectionDetailsState()

    override fun handleEvents(event: CollectionDetailsEvent) {
        when (event) {
            is CollectionDetailsEvent.NavigateUp -> {
                navigator.navigateUp()
            }
            is CollectionDetailsEvent.LoadCollectionDetails -> {
                loadCollectionDetails(collectionId = event.collectionId)
            }
        }
    }

    private fun loadCollectionDetails(collectionId: String) {
        viewModelScope.launch {
            collectionUseCase.loadCollectionDetails(
                collectionId = collectionId,
                onSuccess = { collectionDetailsModel ->
                    // TODO: update state
                },
                onError = { throwable ->
                    navigator.onError(throwable = throwable)
                }
            )
        }
    }
}