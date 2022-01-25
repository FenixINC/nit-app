package com.inquisitor.feature_login.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inquisitor.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel(), Navigator by navigator {
    fun login() {
        viewModelScope.launch {
            kotlin.runCatching {

            }.onSuccess {

            }.onFailure {

            }
        }
    }
}