package com.inquisitor.data.network.response.open_sea_nft

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainAssetResponse(
    @SerialName(value = "assets") val assetList: List<AssetResponse>
)
