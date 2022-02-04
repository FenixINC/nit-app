package com.inquisitor.nit.ui.home

import androidx.lifecycle.viewModelScope
import com.inquisitor.data.network.error_handling.HttpException
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

    override fun setInitialState() = HomeState.Idle

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            is HomeEvent.LoadNftList -> {
                loadNftList()
            }
            is HomeEvent.Error -> {
                navigator.onError(errorMessage = event.errorMessage)
            }
        }
    }

    private fun loadFilmList() {
        viewModelScope.launch {
            homeUseCase.loadFilmList(
                onSuccess = {
                    val s = ""
                },
                onError = {
                    val e = ""
                }
            )
        }
    }

    private fun loadNftList() {
        viewModelScope.launch {
            homeUseCase.loadNftList(
                onSuccess = {
                    val s = it
                },
                onError = { throwable ->
                    when (throwable) {
                        is HttpException -> {
                            navigator.onError(errorMessage = throwable.errorMessage ?: "")
                        }
                    }
                }
            )
        }
    }
}