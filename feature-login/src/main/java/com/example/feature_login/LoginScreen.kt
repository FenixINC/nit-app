package com.example.feature_login

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common_resources.*

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = hiltViewModel()) {
    BackHandler(onBack = { loginViewModel.setEvent(event = LoginEvent.CloseApp) })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Icon logo",
            modifier = Modifier.size(width = 100.dp, height = 36.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 84.dp)
        )

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            contentPadding = PaddingValues(),
            onClick = { },
            shape = RoundedCornerShape(36.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 48.dp)
                    .background(
                        shape = RoundedCornerShape(36.dp),
                        brush = Brush.verticalGradient(colors = listOf(yellowLight, yellow))
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = textLogIn,
                    color = grayText,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 16.dp)
        )

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            contentPadding = PaddingValues(),
            onClick = { },
            shape = RoundedCornerShape(36.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 48.dp)
                    .background(shape = RoundedCornerShape(36.dp), color = grayButton),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = textBecomeClientOfTheBank,
                    fontSize = 16.sp,
                    color = white
                )
            }
        }
    }
}