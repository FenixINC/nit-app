package com.inquisitor.nit.ui.login

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import com.inquisitor.nit.R

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = hiltViewModel()) {
    BackHandler(onBack = { loginViewModel.onCloseApp() })

    val loginState = loginViewModel.viewState.collectAsState()

    var passwordVisibility: Boolean by remember { mutableStateOf(value = false) }
    var username by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { newText -> username = newText },
            label = { Text(text = stringResource(id = R.string.username)) }
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = dimensionResource(id = R.dimen.spacer_default))
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = stringResource(id = R.string.password)) },
            placeholder = { Text(text = stringResource(id = R.string.enter_password)) },
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisibility)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        imageVector = image,
                        contentDescription = "Password is $passwordVisibility"
                    )
                }
            }
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = dimensionResource(id = R.dimen.spacer_default))
        )

        Button(
            onClick = {
//                loginViewModel.login(
//                    username = username,
//                    password = password
//                )
            }
        ) {
            Text(text = stringResource(id = R.string.login))
        }
    }
}