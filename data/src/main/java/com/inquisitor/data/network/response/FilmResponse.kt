package com.inquisitor.data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmResponse(
    @SerialName(value = "id") val id: String = "",
    @SerialName(value = "title") val title: String? = "",
    @SerialName(value = "director") val director: String? = "",
    @SerialName(value = "producer") val producer: String? = "",
    @SerialName(value = "original_title") val originalTitle: String? = "",
    @SerialName(value = "movie_banner") val movieBanner: String? = "",
    @SerialName(value = "description") val description: String? = "",
    @SerialName(value = "release_date") val releaseDate: String? = "",
    @SerialName(value = "people") val peopleList: List<String>? = mutableListOf()
)
