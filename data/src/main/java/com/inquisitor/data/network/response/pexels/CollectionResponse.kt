package com.inquisitor.data.network.response.pexels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionResponse(
    @SerialName(value = "id") val id: Long? = 0L,
    @SerialName(value = "title") val title: String? = "",
    @SerialName(value = "description") val description: String? = "",
    @SerialName(value = "private") val private: Boolean? = false,
    @SerialName(value = "media_count") val mediaCount: Int? = 0,
    @SerialName(value = "photos_count") val photosCount: Int? = 0,
    @SerialName(value = "videos_count") val videosCount: Int? = 0
)