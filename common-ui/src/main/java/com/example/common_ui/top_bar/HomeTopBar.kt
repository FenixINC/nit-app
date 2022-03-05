package com.example.common_ui.top_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common_resources.toolbarHeight
import com.example.navigation.top_bar_config.TopBarHomeConfig

@Composable
fun HomeTopBar(
    nitTopBarViewModel: NitTopBarViewModel = hiltViewModel(),
    topBarHomeConfig: TopBarHomeConfig
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = toolbarHeight)
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        val (iconProfile, iconLogo) = createRefs()

        IconButton(
            onClick = { nitTopBarViewModel.setEvent(event = ToolbarEvent.OpenProfile) },
            modifier = Modifier.constrainAs(iconProfile) {
                start.linkTo(anchor = parent.start)
                top.linkTo(anchor = parent.top)
                bottom.linkTo(anchor = parent.bottom)
            }
        ) {
            Image(
                painter = painterResource(id = topBarHomeConfig.iconProfile),
                contentDescription = "Profile image"
            )
        }

        Image(
            painter = painterResource(id = topBarHomeConfig.iconLogo),
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
    }
}