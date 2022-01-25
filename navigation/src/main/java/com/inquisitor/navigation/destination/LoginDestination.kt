package com.inquisitor.navigation.destination

import com.inquisitor.navigation.NavigationConstants.ROUTE_LOGIN

object LoginDestination : NavigationDestination {
    override fun route(): String = ROUTE_LOGIN

//    override val arguments: List<NamedNavArgument>
//        get() = listOf(navArgument(BOOK_ID_PARAM) { type = NavType.IntType })

//    const val BOOK_ID_PARAM = "book"

//    fun createBookDetailsRoute() = "$ROUTE_LOGIN/${bookID}"
}