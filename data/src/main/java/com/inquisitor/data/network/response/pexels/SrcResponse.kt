package com.inquisitor.data.network.response.pexels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SrcResponse(
    @SerialName(value = "original") val original: String? = ",",
    @SerialName(value = "large2x") val large2x: String? = "",
    @SerialName(value = "large") val large: String? = "",
    @SerialName(value = "medium") val medium: String? = "",
    @SerialName(value = "small") val small: String? = "",
    @SerialName(value = "portrait") val portrait: String? = "",
    @SerialName(value = "landscape") val landscape: String? = "",
    @SerialName(value = "tiny") val tiny: String? = ""
)