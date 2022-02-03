package com.inquisitor.nit.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inquisitor.domain.usecase.HomeUseCase
import com.inquisitor.nit.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator,
    private val homeUseCase: HomeUseCase
) : ViewModel(), Navigator by navigator {
    fun loadFilmList() {
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
}