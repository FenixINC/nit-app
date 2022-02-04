package com.inquisitor.data.network.response.open_sea_nft

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionResponse(
    @SerialName(value = "banner_image_url") val bannerImageUrl: String? = "",
    @SerialName(value = "image_url") val imageUrl: String? = "",
    @SerialName(value = "large_image_url") val largeImageUrl: String? = "",
    @SerialName(value = "chat_url") val chatUrl: String? = "",
    @SerialName(value = "discord_url") val discord_url: String? = "",
    @SerialName(value = "created_date") val createdDate: String? = "",
    @SerialName(value = "description") val description: String? = "",
    @SerialName(value = "dev_buyer_fee_basis_points") val devBuyerFeeBasisPoints: String? = "",
    @SerialName(value = "dev_seller_fee_basis_points") val dev_seller_fee_basis_points: String? = "",
    @SerialName(value = "external_url") val externalUrl: String? = "",
    @SerialName(value = "name") val name: String? = "",
    @SerialName(value = "slug") val slug: String? = "",
    @SerialName(value = "telegram_url") val telegramUrl: String? = "",
    @SerialName(value = "twitter_username") val twitterUsername: String? = "",
    @SerialName(value = "instagram_username") val instagramUsername: String? = "",
    @SerialName(value = "wiki_url") val wikiUrl: String? = ""
)