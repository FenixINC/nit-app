package com.inquisitor.domain.model

data class VideoModel(
    val id: Long,
    val width: Int,
    val height: Int,
    val duration: Int,
    val fullRes: String,
    val tagList: List<String>,
    val url: String,
    val image: String,
    val userModel: UserModel,
    val videoFileModelList: List<VideoFileModel>,
    val videoPictureModelList: List<VideoPictureModel>
)