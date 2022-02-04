package com.inquisitor.domain.mapper

import com.inquisitor.data.network.response.open_sea_nft.CollectionResponse
import com.inquisitor.domain.model.CollectionModel

fun CollectionResponse.mapToModel() = CollectionModel(
    bannerImageUrl = this.bannerImageUrl,
    imageUrl = this.imageUrl,
    largeImageUrl = this.largeImageUrl,
    chatUrl = this.chatUrl,
    discordUrl = this.discord_url,
    createdDate = this.createdDate,
    description = this.description,
    devBuyerFeeBasisPoints = this.devBuyerFeeBasisPoints,
    devSellerFeeBasisPoints = this.dev_seller_fee_basis_points,
    externalUrl = this.externalUrl,
    name = this.name,
    slug = this.slug,
    telegramUrl = this.telegramUrl,
    twitterUsername = this.twitterUsername,
    instagramUsername = this.instagramUsername,
    wikiUrl = this.wikiUrl
)