package com.inquisitor.domain.model

import com.inquisitor.data.network.response.open_sea_nft.AssetResponse
import com.inquisitor.data.network.response.open_sea_nft.MainUserResponse

data class MainBundleModel(
    val bundleList: List<BundleModel>? = emptyList()
)

data class BundleModel(
    val name: String? = "",
    val slug: String? = "",
    val description: String? = "",
    val externalLink: String? = "",
    val permalink: String? = "",
    val mainUser: MainUserModel? = MainUserModel(),
    val assetList: List<AssetModel>? = emptyList()
)