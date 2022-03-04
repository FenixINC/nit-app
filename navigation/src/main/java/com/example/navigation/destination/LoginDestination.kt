package com.example.navigation.destination

import com.example.navigation.NavigationConstants.ROUTE_LOGIN
import com.example.navigation.NavigationDestination

object LoginDestination : NavigationDestination {
    override fun route(): String = ROUTE_LOGIN
}