package com.inquisitor.domain.model.pexels

data class CollectionDetailsModel(
    val id: Long? = 0L,
    val page: Long? = 0L,
    val perPage: Long? = 0L,
    val mediaList: List<MediaModel>? = emptyList(),
    val totalResults: Long? = 0L,
    val nextPage: String? = ""
)