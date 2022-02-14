package com.inquisitor.nit.ui.main

import com.inquisitor.nit.base.BaseViewModel
import com.inquisitor.nit.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : BaseViewModel<MainEvent, MainState, MainEffect>() {

    override fun setInitialState() = MainState()

    override fun handleEvents(event: MainEvent) {
        when (event) {
            is MainEvent.TopBar -> {

            }
        }
    }
}