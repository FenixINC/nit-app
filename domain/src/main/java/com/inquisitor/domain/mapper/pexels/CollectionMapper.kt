package com.inquisitor.domain.mapper.pexels

import com.inquisitor.data.network.response.pexels.CollectionDetailsResponse
import com.inquisitor.data.network.response.pexels.CollectionResponse
import com.inquisitor.domain.model.pexels.CollectionDetailsModel
import com.inquisitor.domain.model.pexels.CollectionModel

fun List<CollectionResponse>.mapToModel() = map { collectionResponse ->
    CollectionModel(
        id = collectionResponse.id,
        title = collectionResponse.title,
        description = collectionResponse.description,
        private = collectionResponse.private,
        mediaCount = collectionResponse.mediaCount,
        photosCount = collectionResponse.photosCount,
        videosCount = collectionResponse.videosCount
    )
}

fun CollectionDetailsResponse.mapToModel() = CollectionDetailsModel(
    id = this.id,
    page = this.page,
    perPage = this.perPage,
    mediaList = this.mediaList?.mapToModel(),
    totalResults = this.totalResults,
    nextPage = this.nextPage
)