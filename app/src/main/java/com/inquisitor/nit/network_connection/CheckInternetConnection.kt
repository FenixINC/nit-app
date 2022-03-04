package com.inquisitor.nit.network_connection

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CheckInternetConnection(
    networkStatusViewModel: NetworkStatusViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        networkStatusViewModel.networkStatusState.collectLatest { networkStatusResultState ->
            networkStatusViewModel.sendInternetConnectionState(
                networkStatusResultState = networkStatusResultState
            )
        }
    }
}