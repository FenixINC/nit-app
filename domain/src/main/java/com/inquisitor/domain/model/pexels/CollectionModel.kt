package com.inquisitor.domain.model.pexels

data class CollectionModel(
    val id: Long? = 0L,
    val title: String? = "",
    val description: String? = "",
    val private: Boolean? = false,
    val mediaCount: Int? = 0,
    val photosCount: Int? = 0,
    val videosCount: Int? = 0
)