package com.inquisitor.feature_login

data class LoginState(
    val isLoading: Boolean? = false,
    val result: String? = null,
    val errorMessage: String? = null
)