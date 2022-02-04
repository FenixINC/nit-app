package com.inquisitor.domain.model

data class AssetModel(
    val id: Long? = 0L,
    val tokenId: String? = "",
    val numSales: Int? = 0,
    val backgroundColor: String? = "",
    val imageUrl: String? = "",
    val imagePreviewUrl: String? = "",
    val imageThumbnailUrl: String? = "",
    val imageOriginalUrl: String? = "",
    val name: String? = "",
    val description: String? = "",
    val externalLink: String? = "",
    val permalink: String? = "",
    val owner: MainUserModel? = MainUserModel(),
    val collection: CollectionModel? = CollectionModel(),
)
