package com.inquisitor.domain.model

data class VideoFileModel(
    val id: Long? = 0L,
    val quality: String? = "",
    val fileType: String? = "",
    val width: Int? = 0,
    val height: Int? = 0,
    val link: String? = ""
)