package com.inquisitor.data.network.response.pexels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoPictureResponse(
    @SerialName(value = "id") val id: Long? = 0L,
    @SerialName(value = "nr") val nr: Int? = 0,
    @SerialName(value = "picture") val picture: String? = ""
)