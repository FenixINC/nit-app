package com.inquisitor.nit.navigation.destination

import com.inquisitor.nit.navigation.NavigationConstants
import com.inquisitor.nit.navigation.NavigationDestination

object SplashDestination : NavigationDestination {
    override fun route(): String = NavigationConstants.ROUTE_SPLASH

    const val ARG_ID = "arg_id"
}