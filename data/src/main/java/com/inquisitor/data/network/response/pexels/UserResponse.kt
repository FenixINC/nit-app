package com.inquisitor.data.network.response.pexels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName(value = "id") val id: Long? = 0L,
    @SerialName(value = "name") val name: String? = "",
    @SerialName(value = "url") val url: String? = ""
)