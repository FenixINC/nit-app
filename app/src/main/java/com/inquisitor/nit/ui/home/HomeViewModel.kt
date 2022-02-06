package com.inquisitor.nit.ui.home

import androidx.lifecycle.viewModelScope
import com.inquisitor.domain.usecase.HomeUseCase
import com.inquisitor.nit.base.BaseViewModel
import com.inquisitor.nit.navigation.Navigator
import com.inquisitor.nit.navigation.destination.CollectionDetailsDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator,
    private val homeUseCase: HomeUseCase
) : BaseViewModel<HomeEvent, HomeState, HomeEffect>(), Navigator by navigator {

    override fun setInitialState() = HomeState()

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            is HomeEvent.LoadCollectionList -> {
                loadCollectionList()
            }
            is HomeEvent.LoadPhotoList -> {
                loadPhotoList()
            }
            is HomeEvent.OpenCollectionDetails -> {
                openCollectionDetails(collectionId = event.collectionId)
            }
        }
    }

    private fun loadCollectionList() {
        viewModelScope.launch {
            homeUseCase.loadCollectionList(
                onSuccess = { collectionList ->
                    setState {
                        copy(collectionList = collectionList)
                    }
                },
                onError = { throwable ->
                    navigator.onError(throwable = throwable)
                }
            )
        }
    }

    private fun loadPhotoList() {
        viewModelScope.launch {
            homeUseCase.loadPhotoListBySearchKey(
                searchKey = "Popular",
                onSuccess = {
                    val s = it
                },
                onError = { throwable ->

                }
            )
        }
    }

    private fun openCollectionDetails(collectionId: String) {
        viewModelScope.launch {
            navigator.navigate(
                route = CollectionDetailsDestination.createCollectionDetailsDestination(
                    collectionId = collectionId
                )
            )
        }
    }
}