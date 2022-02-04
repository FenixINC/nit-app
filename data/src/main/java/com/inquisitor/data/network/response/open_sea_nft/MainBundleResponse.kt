package com.inquisitor.data.network.response.open_sea_nft

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainBundleResponse(
    @SerialName(value = "bundles") val bundleList: List<BundleResponse>? = emptyList()
)

@Serializable
data class BundleResponse(
    @SerialName(value = "name") val name: String? = "",
    @SerialName(value = "slug") val slug: String? = "",
    @SerialName(value = "description") val description: String? = "",
    @SerialName(value = "external_link") val externalLink: String? = "",
    @SerialName(value = "permalink") val permalink: String? = "",
    @SerialName(value = "maker") val mainUser: MainUserResponse? = MainUserResponse(),
    @SerialName(value = "assets") val assetList: List<AssetResponse>? = emptyList()
)