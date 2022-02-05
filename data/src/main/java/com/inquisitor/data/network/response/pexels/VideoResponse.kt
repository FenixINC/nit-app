package com.inquisitor.data.network.response.pexels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoResponse(
    @SerialName(value = "id") val id: Long? = 0L,
    @SerialName(value = "width") val width: Int? = 0,
    @SerialName(value = "height") val height: Int? = 0,
    @SerialName(value = "duration") val duration: Int? = 0,
    @SerialName(value = "full_res") val fullRes: String? = "",
    @SerialName(value = "tags") val tagList: List<String>? = emptyList(),
    @SerialName(value = "url") val url: String? = "",
    @SerialName(value = "image") val image: String? = "",
    @SerialName(value = "user") val userResponse: UserResponse? = UserResponse(),
    @SerialName(value = "video_files") val videoFileList: List<VideoFile>? = emptyList(),
    @SerialName(value = "video_pictures") val videoPictureList: List<VideoPicture>? = emptyList()
)