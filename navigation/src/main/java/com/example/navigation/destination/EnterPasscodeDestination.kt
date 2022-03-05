package com.example.navigation.destination

import com.example.navigation.NavigationConstants.ROUTE_ENTER_PASSCODE
import com.example.navigation.NavigationDestination

object EnterPasscodeDestination : NavigationDestination {
    override fun route(): String = ROUTE_ENTER_PASSCODE
}