package com.inquisitor.data.network.response.open_sea_nft

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName(value = "username") val username: String? = ""
)