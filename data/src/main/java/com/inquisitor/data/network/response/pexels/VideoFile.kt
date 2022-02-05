package com.inquisitor.data.network.response.pexels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoFile(
    @SerialName(value = "id") val id: Long? = 0L,
    @SerialName(value = "quality") val quality: String? = "",
    @SerialName(value = "file_type") val fileType: String? = "",
    @SerialName(value = "width") val width: Int? = 0,
    @SerialName(value = "height") val height: Int? = 0,
    @SerialName(value = "link") val link: String? = ""
)