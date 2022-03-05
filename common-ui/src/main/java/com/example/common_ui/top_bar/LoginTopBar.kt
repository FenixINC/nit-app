package com.example.common_ui.top_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common_resources.toolbarHeight
import com.example.navigation.top_bar_config.TopBarLoginConfig

@Composable
fun LoginTopBar(
    nitTopBarViewModel: NitTopBarViewModel = hiltViewModel(),
    topBarLoginConfig: TopBarLoginConfig
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = toolbarHeight)
    ) {
        val (iconLogo, iconMore) = createRefs()

        Image(
            painter = painterResource(id = topBarLoginConfig.iconLogo),
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
                nitTopBarViewModel.setEvent(event = TopBarEvent.OpenMore)
            },
            modifier = Modifier.constrainAs(iconMore) {
                top.linkTo(anchor = parent.top)
                end.linkTo(anchor = parent.end)
                bottom.linkTo(anchor = parent.bottom)
            }
        ) {
            Image(
                painter = painterResource(id = topBarLoginConfig.iconMore),
                contentDescription = "Icon more"
            )
        }
    }
}