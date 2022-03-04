package com.inquisitor.nit.network_connection

import androidx.lifecycle.ViewModel
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class NetworkStatusViewModel @Inject constructor(
    private val networkStatusTracker: NetworkStatusTracker,
    private val navigator: Navigator
) : ViewModel() {

    private val _networkStatusState = networkStatusTracker.networkStatus
        .map(
            onUnavailable = { NetworkStatusResultState.Error },
            onAvailable = { NetworkStatusResultState.Success },
        )
    val networkStatusState: Flow<NetworkStatusResultState> = _networkStatusState

    fun sendInternetConnectionState(networkStatusResultState: NetworkStatusResultState) {
//        navigator.setInternetConnectionState(networkStatusResultState = networkStatusResultState)
    }
}