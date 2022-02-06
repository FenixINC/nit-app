package com.inquisitor.data.network.response.pexels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaResponse(
    @SerialName(value = "id") val id: Long? = 0L,
    @SerialName(value = "type") val type: String? = "",
    @SerialName(value = "width") val width: Long? = 0L,
    @SerialName(value = "height") val height: Long? = 0L,
    @SerialName(value = "url") val url: String? = "",
    @SerialName(value = "photographer") val photographerName: String? = "",
    @SerialName(value = "photographer_url") val photographerUrl: String? = "",
    @SerialName(value = "photographer_id") val photographerId: Long? = 0L,
    @SerialName(value = "avg_color") val avgColor: String? = "",
    @SerialName(value = "src") val srcResponse: SrcResponse? = SrcResponse(),
    @SerialName(value = "liked") val liked: Boolean? = false,
    @SerialName(value = "alt") val alt: String? = "",

    @SerialName(value = "duration") val duration: Int? = 0,
    @SerialName(value = "full_res") val fullRes: String? = "",
    @SerialName(value = "tags") val tagList: List<String>? = emptyList(),
    @SerialName(value = "image") val image: String? = "",
    @SerialName(value = "user") val userResponse: UserResponse? = UserResponse(),
    @SerialName(value = "video_files") val videoFileResponseList: List<VideoFileResponse>? = emptyList(),
    @SerialName(value = "video_pictures") val videoPictureResponseList: List<VideoPictureResponse>? = emptyList()
)