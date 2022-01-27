package com.inquisitor.navigation.destination

import com.inquisitor.navigation.NavigationConstants.ROUTE_HOME

object HomeDestination : NavigationDestination {
    override fun route(): String = ROUTE_HOME
}