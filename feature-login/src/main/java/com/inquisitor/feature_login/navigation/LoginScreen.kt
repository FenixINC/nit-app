package com.inquisitor.feature_login.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen() {
    val loginViewModel = hiltViewModel<LoginViewModel>()
    BackHandler(onBack = { loginViewModel.onCloseApp() })

    Text(text = "LOGIN SCREEN", modifier = Modifier.fillMaxSize())
}