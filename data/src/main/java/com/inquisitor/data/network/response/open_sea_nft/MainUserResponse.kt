package com.inquisitor.data.network.response.open_sea_nft

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainUserResponse(
    @SerialName(value = "user") val user: UserResponse? = UserResponse(),
    @SerialName(value = "profile_img_url") val profileImgUrl: String? = "",
    @SerialName(value = "address") val address: String? = "",
    @SerialName(value = "config") val config: String? = ""
)