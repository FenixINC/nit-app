package com.inquisitor.nit.network_connection

sealed class NetworkStatusResultState {
    object Success : NetworkStatusResultState()
    object Error : NetworkStatusResultState()
}