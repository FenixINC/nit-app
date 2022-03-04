package com.example.navigation.destination

import com.example.navigation.NavigationConstants.ROUTE_HOME
import com.example.navigation.NavigationDestination

object HomeDestination: NavigationDestination {
    override fun route(): String = ROUTE_HOME
}