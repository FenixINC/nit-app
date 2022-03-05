package com.example.common_ui.bottom_bar

import androidx.annotation.DrawableRes
import com.example.common_resources.R
import com.example.navigation.NavigationConstants.ROUTE_BAG
import com.example.navigation.NavigationConstants.ROUTE_CARD
import com.example.navigation.NavigationConstants.ROUTE_CHAT
import com.example.navigation.NavigationConstants.ROUTE_CLOCK
import com.example.navigation.NavigationConstants.ROUTE_HOME

sealed class BottomNavItem(var route: String, @DrawableRes var icon: Int, var title: String) {
    object Home : BottomNavItem(
        route = ROUTE_HOME,
        icon = R.drawable.ic_home_active,
        title = "Home"
    )

    object Bag : BottomNavItem(
        route = ROUTE_BAG,
        icon = R.drawable.ic_bag_inactive,
        title = "Bag"
    )

    object Card : BottomNavItem(
        route = ROUTE_CARD,
        icon = R.drawable.ic_card_inactive,
        title = "Card"
    )

    object Chat : BottomNavItem(
        route = ROUTE_CHAT,
        icon = R.drawable.ic_chat_inactive,
        title = "Chat"
    )

    object Clock : BottomNavItem(
        route = ROUTE_CLOCK,
        icon = R.drawable.ic_clock_inactive,
        title = "Clock"
    )
}