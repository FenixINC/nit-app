package com.inquisitor.nit.navigation.destination

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.inquisitor.nit.navigation.NavigationConstants.ARG_COLLECTION_ID
import com.inquisitor.nit.navigation.NavigationConstants.ROUTE_COLLECTION_DETAILS
import com.inquisitor.nit.navigation.NavigationDestination

object CollectionDetailsDestination : NavigationDestination {

    override fun route() = ROUTE_COLLECTION_DETAILS_DESTINATION

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(ARG_COLLECTION_ID) { type = NavType.StringType }
        )

    private const val ROUTE_COLLECTION_DETAILS_DESTINATION =
        "$ROUTE_COLLECTION_DETAILS/{$ARG_COLLECTION_ID}"

    fun createCollectionDetailsDestination(collectionId: String) =
        "$ROUTE_COLLECTION_DETAILS/${collectionId}"
}