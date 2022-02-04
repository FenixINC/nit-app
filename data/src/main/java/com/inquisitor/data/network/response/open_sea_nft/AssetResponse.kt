package com.inquisitor.data.network.response.open_sea_nft

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssetResponse(
    @SerialName(value = "id") val id: Long? = 0L,
    @SerialName(value = "token_id") val tokenId: String? = "",
    @SerialName(value = "num_sales") val numSales: Int? = 0,
    @SerialName(value = "background_color") val backgroundColor: String? = "",
    @SerialName(value = "image_url") val image_url: String? = "",
    @SerialName(value = "image_preview_url") val image_preview_url: String? = "",
    @SerialName(value = "image_thumbnail_url") val image_thumbnail_url: String? = "",
    @SerialName(value = "image_original_url") val image_original_url: String? = "",
    @SerialName(value = "name") val name: String? = "",
    @SerialName(value = "description") val description: String? = "",
    @SerialName(value = "external_link") val external_link: String? = "",
    @SerialName(value = "permalink") val permalink: String? = "",
    @SerialName(value = "owner") val owner: MainUserResponse? = MainUserResponse(),
    @SerialName(value = "collection") val collection: CollectionResponse? = CollectionResponse()
)