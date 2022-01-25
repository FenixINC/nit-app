package com.inquisitor.navigation.destination

import com.inquisitor.navigation.NavigationConstants

object SplashDestination : NavigationDestination {
    override fun route(): String = NavigationConstants.ROUTE_SPLASH

    const val ARG_ID = "arg_id"
}