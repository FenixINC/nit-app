package com.inquisitor.nit.ui.base.top_bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.inquisitor.nit.R
import com.inquisitor.nit.ui.resources.toolbarHeight

@Composable
fun NitTopBar(
    nitTopBarViewModel: NitTopBarViewModel = hiltViewModel(),
    iconBackState: MutableState<Boolean> = mutableStateOf(value = false)
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = toolbarHeight)
    ) {
        val (iconProfile, iconBack, iconLogo, iconMore) = createRefs()

        AnimatedVisibility(visible = iconBackState.value) {
            IconButton(
                onClick = { nitTopBarViewModel.setEvent(event = ToolbarEvent.NavigateUp) },
                modifier = Modifier.constrainAs(iconBack) {
                    start.linkTo(anchor = parent.start)
                    top.linkTo(anchor = parent.top)
                    bottom.linkTo(anchor = parent.bottom)
                }
            ) {
                Image(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Icon back"
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Icon logo",
            modifier = Modifier
                .size(width = 72.dp, height = 21.dp)
                .constrainAs(iconLogo) {
                    start.linkTo(anchor = parent.start)
                    top.linkTo(anchor = parent.top)
                    end.linkTo(anchor = parent.end)
                    bottom.linkTo(anchor = parent.bottom)
                }
        )

        IconButton(
            onClick = {
                nitTopBarViewModel.setEvent(event = ToolbarEvent.OpenMore)
            },
            modifier = Modifier.constrainAs(iconMore) {
                top.linkTo(anchor = parent.top)
                end.linkTo(anchor = parent.end)
                bottom.linkTo(anchor = parent.bottom)
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "Icon more"
            )
        }
    }

//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(height = toolbarHeight)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = space16dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            AnimatedVisibility(visible = iconBackState.value) {
//                IconButton(
//                    onClick = { nitTopBarViewModel.setEvent(event = ToolbarEvent.NavigateUp) }
//                ) {
//                    Image(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "Icon back"
//                    )
//                }
//            }
//            Image(
//                painter = painterResource(id = R.drawable.ic_logo),
//                contentDescription = "Icon logo",
//                modifier = Modifier.size(width = 72.dp, height = 21.dp)
//            )
//
//            IconButton(
//                onClick = {
//                    nitTopBarViewModel.setEvent(event = ToolbarEvent.OpenMore)
//                }
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_more),
//                    contentDescription = "Icon more"
//                )
//            }
//        }
//    }
}