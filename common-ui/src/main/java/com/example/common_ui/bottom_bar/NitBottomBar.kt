package com.example.common_ui.bottom_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.common_resources.bottomNavBackground
import com.example.common_resources.gray3
import com.example.common_resources.white
import com.example.common_resources.yellow

@Composable
fun NitBottomBar(
    bottomBarViewModel: NitBottomBarViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = bottomNavBackground,
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            )
    ) {
        getBottomNavData().forEach { bottomNavItem ->
            BottomNavigationItem(
                icon = {
                    Image(
                        painter = painterResource(id = bottomNavItem.icon),
                        contentDescription = bottomNavItem.title,
                        colorFilter = if (currentRoute == bottomNavItem.route) {
                            ColorFilter.tint(color = yellow)
                        } else {
                            ColorFilter.tint(color = white)
                        }
                    )
                },
                selectedContentColor = gray3,
                alwaysShowLabel = false,
                selected = currentRoute == bottomNavItem.route,
                onClick = {
                    bottomBarViewModel.setEvent(
                        event = BottomBarEvent.Navigate(route = bottomNavItem.route)
                    )
                }
            )
        }
    }
}