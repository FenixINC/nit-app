package com.inquisitor.domain.model

data class PhotoModel(
    val id: Long,
    val width: Long,
    val height: Long,
    val url: String,
    val photographerName: String,
    val photographerUrl: String,
    val photographerId: Long,
    val avgColor: String,
    val srcResponse: SrcModel,
    val liked: Boolean,
    val alt: String
)