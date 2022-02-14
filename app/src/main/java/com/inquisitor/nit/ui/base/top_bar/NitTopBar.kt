package com.inquisitor.nit.ui.base.top_bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.inquisitor.nit.R
import com.inquisitor.nit.ui.resources.space16dp
import com.inquisitor.nit.ui.resources.toolbarHeight

@Composable
fun NitTopBar(
    nitTopBarViewModel: NitTopBarViewModel = hiltViewModel(),
    topBarState: MutableState<Boolean> = mutableStateOf(value = false)
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = toolbarHeight)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = space16dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(visible = topBarState.value) {
                IconButton(
                    onClick = { nitTopBarViewModel.setEvent(event = ToolbarEvent.NavigateUp) }
                ) {
                    Image(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Icon back"
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Icon logo"
            )

            Row(
                modifier = Modifier.wrapContentSize(),
                horizontalArrangement = Arrangement.spacedBy(space = space16dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { nitTopBarViewModel.setEvent(event = ToolbarEvent.OpenProfile) }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Icon profile"
                    )
                }

                IconButton(
                    onClick = { nitTopBarViewModel.setEvent(event = ToolbarEvent.OpenMenu) }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = "Icon menu"
                    )
                }

            }
        }
    }
}