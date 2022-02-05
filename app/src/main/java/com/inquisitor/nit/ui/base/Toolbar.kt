package com.inquisitor.nit.ui.base

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.inquisitor.nit.R
import com.inquisitor.nit.ui.resources.space16dp
import com.inquisitor.nit.ui.resources.toolbarHeight

@Composable
fun Toolbar(showArrowBack: Boolean = false) {
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
            AnimatedVisibility(visible = showArrowBack) {
                Image(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Icon back"
                )
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
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Icon profile"
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = "Icon menu"
                )
            }

        }
    }
}