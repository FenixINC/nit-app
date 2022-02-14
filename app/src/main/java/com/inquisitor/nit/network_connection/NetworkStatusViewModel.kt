package com.inquisitor.nit.network_connection

import androidx.lifecycle.ViewModel
import com.inquisitor.nit.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NetworkStatusViewModel @Inject constructor(
    private val networkStatusTracker: NetworkStatusTracker,
    private val navigator: Navigator
) : ViewModel() {

    var state = networkStatusTracker.networkStatus
        .map(
            onUnavailable = { NetworkStatusResultState.Error },
            onAvailable = { NetworkStatusResultState.Success },
        )
        private set

    fun sendInternetConnectionState(networkStatusResultState: NetworkStatusResultState) {
        navigator.setInternetConnectionState(networkStatusResultState = networkStatusResultState)
    }
}