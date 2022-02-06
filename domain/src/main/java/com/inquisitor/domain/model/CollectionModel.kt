package com.inquisitor.domain.model

data class CollectionModel(
    val id: String = "",
    val title: String? = "",
    val description: String? = "",
    val private: Boolean? = false,
    val mediaCount: Int? = 0,
    val photosCount: Int? = 0,
    val videosCount: Int? = 0
)