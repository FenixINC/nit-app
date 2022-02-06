package com.inquisitor.nit.navigation.destination

import com.inquisitor.nit.navigation.NavigationConstants.ROUTE_SPLASH
import com.inquisitor.nit.navigation.NavigationDestination

object SplashDestination : NavigationDestination {
    override fun route(): String = ROUTE_SPLASH
}