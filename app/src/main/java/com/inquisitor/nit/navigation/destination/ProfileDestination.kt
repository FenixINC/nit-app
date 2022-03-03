package com.inquisitor.nit.navigation.destination

import com.inquisitor.nit.navigation.NavigationConstants.ROUTE_PROFILE
import com.inquisitor.nit.navigation.NavigationDestination

object ProfileDestination : NavigationDestination {
    override fun route() = ROUTE_PROFILE
}