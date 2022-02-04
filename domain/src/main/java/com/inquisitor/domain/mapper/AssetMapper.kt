package com.inquisitor.domain.mapper

import com.inquisitor.data.network.response.open_sea_nft.AssetResponse
import com.inquisitor.domain.model.AssetModel

fun List<AssetResponse>.mapToModel() = this.map { assetResponse ->
    AssetModel(
        id = assetResponse.id,
        tokenId = assetResponse.tokenId,
        numSales = assetResponse.numSales,
        backgroundColor = assetResponse.backgroundColor,
        imageUrl = assetResponse.image_original_url,
        imagePreviewUrl = assetResponse.image_preview_url,
        imageThumbnailUrl = assetResponse.image_thumbnail_url,
        imageOriginalUrl = assetResponse.image_original_url,
        name = assetResponse.name,
        description = assetResponse.description,
        externalLink = assetResponse.external_link,
        permalink = assetResponse.permalink,
        owner = assetResponse.owner?.mapToModel(),
        collection = assetResponse.collection?.mapToModel()
    )
}