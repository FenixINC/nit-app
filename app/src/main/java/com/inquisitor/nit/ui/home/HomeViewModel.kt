package com.inquisitor.nit.ui.home

import androidx.lifecycle.viewModelScope
import com.inquisitor.domain.usecase.HomeUseCase
import com.inquisitor.nit.base.BaseViewModel
import com.inquisitor.nit.navigation.Navigator
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
//            is HomeEvent.LoadNftList -> {
//                loadNftList()
//            }
//            is HomeEvent.LoadAssetList -> {
//                loadAssetList()
//            }
//            is HomeEvent.LoadFilmList -> {
//                loadFilmList()
//            }
            is HomeEvent.LoadPhotoList -> {
                loadPhotoList()
            }
            is HomeEvent.Error -> {

            }
        }
    }

//    private fun loadFilmList() {
//        viewModelScope.launch {
//            homeUseCase.loadFilmList(
//                onSuccess = {
//                    val s = ""
//                },
//                onError = {
//                    val e = ""
//                }
//            )
//        }
//    }
//
//    private fun loadNftList() {
//        viewModelScope.launch {
//            homeUseCase.loadNftList(
//                onSuccess = {
//                    val s = it
//                },
//                onError = { throwable ->
//
//                }
//            )
//        }
//    }
//
//    private fun loadAssetList() {
//        viewModelScope.launch {
//            homeUseCase.loadAssetList(
//                onSuccess = { assetList ->
//                    setState {
//                        copy(
//                            isLoading = false,
//                            assetList = assetList
//                        )
//                    }
//                },
//                onError = { throwable ->
//                    navigator.onError(throwable = throwable)
//                }
//            )
//        }
//    }

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
}