package com.inquisitor.domain.model.pexels

data class PhotoModel(
    val id: Long? = 0L,
    val width: Long? = 0L,
    val height: Long? = 0L,
    val url: String? = "",
    val photographerName: String? = "",
    val photographerUrl: String? = "",
    val photographerId: Long? = 0L,
    val avgColor: String? = "",
    val srcResponse: SrcModel? = SrcModel(),
    val liked: Boolean? = false,
    val alt: String? = ""
)