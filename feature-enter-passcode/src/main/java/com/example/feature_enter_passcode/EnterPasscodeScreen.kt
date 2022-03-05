package com.example.feature_enter_passcode

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common_resources.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

private val pinSize = 4

@Composable
fun EnterPasscodeScreen(enterPasscodeViewModel: EnterPasscodeViewModel = hiltViewModel()) {
    BackHandler(onBack = { enterPasscodeViewModel.setEvent(event = EnterPasscodeEvent.OpenLoginScreen) })

    val enterPasscodeState = enterPasscodeViewModel.viewState.collectAsState()
    val enterPasscodeEffect = enterPasscodeViewModel.effect

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 112.dp)
        )

        Text(
            text = textEnterPasscode,
            fontSize = 18.sp,
            color = white
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 20.dp)
        )

        PinLockScreen(
            enterPasscodeViewModel = enterPasscodeViewModel,
            enterPasscodeState = enterPasscodeState.value,
            enterPasscodeEffect = enterPasscodeEffect
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 24.dp)
        )

        Text(
            modifier = Modifier.wrapContentSize(),
            text = textCannotLogin,
            color = yellow,
            fontSize = 14.sp
        )
    }
}

@Composable
private fun PinLockScreen(
    enterPasscodeViewModel: EnterPasscodeViewModel,
    enterPasscodeState: EnterPasscodeState,
    enterPasscodeEffect: Flow<EnterPasscodeEffect>
) {
    val inputPinState = remember { mutableStateListOf<Int>() }
    val errorState = remember { mutableStateOf(value = "") }

    LaunchedEffect(key1 = Unit) {
        enterPasscodeEffect.collectLatest { effect ->
            when (effect) {
                is EnterPasscodeEffect.Loading -> {
                    // TODO: call progress view
                }
                is EnterPasscodeEffect.Error -> {
                    inputPinState.clear()
                    errorState.value = effect.errorMessage
                }
            }
        }
    }

    if (inputPinState.size == 4) {
        enterPasscodeViewModel.setEvent(
            event = EnterPasscodeEvent.Login(
                passCode = inputPinState.joinToString(separator = "")
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            (0 until pinSize).forEach {
                Image(
                    imageVector = Icons.Default.Circle,
                    colorFilter = if (inputPinState.size > it) {
                        ColorFilter.tint(color = yellow)
                    } else {
                        ColorFilter.tint(color = grayCircleBackground)
                    },
                    contentDescription = it.toString(),
                    modifier = Modifier
                        .padding(all = 8.dp)
                        .size(size = 10.dp)
                )
            }
        }

        Text(
            text = errorState.value,
            color = Color.Red,
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(70.dp))

        ConstraintLayout(
            modifier = Modifier
                .wrapContentSize()
                .padding(bottom = 20.dp)
        ) {
            val (firstLine, secondLine, thirdLine, fourthLine) = createRefs()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .constrainAs(ref = firstLine) {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = parent.top)
                        end.linkTo(anchor = parent.end)
                    },
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                (1..3).forEach { number ->
                    PinKeyItem(
                        onClick = { inputPinState.add(number) },
                        pinItem = PinItem(
                            type = PinType.NUMBER,
                            number = number.toString()
                        )
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .constrainAs(ref = secondLine) {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = firstLine.bottom)
                        end.linkTo(anchor = parent.end)
                    },
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                (4..6).forEach { number ->
                    PinKeyItem(
                        onClick = { inputPinState.add(number) },
                        pinItem = PinItem(
                            type = PinType.NUMBER,
                            number = number.toString()
                        )
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .constrainAs(ref = thirdLine) {
                        start.linkTo(anchor = parent.start)
                        top.linkTo(anchor = secondLine.bottom)
                        end.linkTo(anchor = parent.end)
                    },
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                (7..9).forEach { number ->
                    PinKeyItem(
                        onClick = { inputPinState.add(number) },
                        pinItem = PinItem(
                            type = PinType.NUMBER,
                            number = number.toString()
                        )
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .constrainAs(ref = fourthLine) {
                        top.linkTo(anchor = thirdLine.bottom)
                        end.linkTo(anchor = parent.end)
                    },
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                PinKeyItem(pinItem = PinItem(type = PinType.EMPTY))

                PinKeyItem(
                    onClick = { inputPinState.add(0) },
                    pinItem = PinItem(
                        type = PinType.NUMBER,
                        number = 0.toString()
                    )
                )

                PinKeyItem(
                    onClick = {
                        if (inputPinState.isNotEmpty()) {
                            inputPinState.removeLast()
                        }
                    },
                    pinItem = PinItem(
                        type = PinType.ICON,
                        iconDrawable = R.drawable.ic_passcode_back,
                        iconContentDescription = "Button clear"
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun PinKeyItem(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier.padding(8.dp),
    shape: Shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
    elevation: Dp = 4.dp,
    pinItem: PinItem
) {
    when (pinItem.type) {
        PinType.EMPTY -> {
            Box(modifier = Modifier.size(size = 85.dp))
        }
        else -> {
            Surface(
                modifier = modifier,
                shape = shape,
                color = if (pinItem.type == PinType.ICON) {
                    Color.Transparent
                } else {
                    grayButtonBackground
                },
                onClick = onClick,
                elevation = if (pinItem.type == PinType.ICON) {
                    0.dp
                } else {
                    elevation
                },
                indication = rememberRipple(),
                role = Role.Button
            ) {
                Box(
                    modifier = Modifier
                        .size(size = 75.dp)
                        .clickable(onClick = { onClick() }),
                    contentAlignment = Alignment.Center
                ) {
                    when (pinItem.type) {
                        PinType.NUMBER -> {
                            Text(
                                text = pinItem.number,
                                fontSize = 36.sp,
                                color = black
                            )
                        }
                        PinType.ICON -> {
                            Image(
                                painter = painterResource(id = pinItem.iconDrawable),
                                contentDescription = pinItem.iconContentDescription,
                                modifier = Modifier
                                    .size(size = 26.dp)
                                    .align(alignment = Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}