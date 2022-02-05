package com.inquisitor.data.network.response.pexels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainPhotoResponse(
    @SerialName(value = "page") val page: Long? = 0L,
    @SerialName(value = "per_page") val perPage: Long? = 0L,
    @SerialName(value = "photos") val photoList: List<PhotoResponse>? = emptyList(),
    @SerialName(value = "total_results") val totalResults: Long? = 0L,
    @SerialName(value = "next_page") val nextPage: String? = ""
)