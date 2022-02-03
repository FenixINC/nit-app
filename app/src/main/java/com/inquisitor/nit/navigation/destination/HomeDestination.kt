package com.inquisitor.nit.navigation.destination

import com.inquisitor.nit.navigation.NavigationConstants.ROUTE_HOME
import com.inquisitor.nit.navigation.NavigationDestination

object HomeDestination : NavigationDestination {
    override fun route(): String = ROUTE_HOME
}