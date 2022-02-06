package com.inquisitor.domain.model.pexels

data class MediaModel(
    val id: Long? = 0L,
    val type: String? = "",
    val width: Long? = 0L,
    val height: Long? = 0L,
    val url: String? = "",
    val photographerName: String? = "",
    val photographerUrl: String? = "",
    val photographerId: Long? = 0L,
    val avgColor: String? = "",
    val srcModel: SrcModel? = SrcModel(),
    val liked: Boolean? = false,
    val alt: String? = "",

    val duration: Int? = 0,
    val fullRes: String? = "",
    val tagList: List<String>? = emptyList(),
    val image: String? = "",
    val userModel: UserModel? = UserModel(),
    val videoFileList: List<VideoFileModel>? = emptyList(),
    val videoPictureList: List<VideoPictureModel>? = emptyList()
)