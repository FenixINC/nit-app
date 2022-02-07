package com.inquisitor.domain.mapper

import com.inquisitor.data.network.response.pexels.PhotoResponse
import com.inquisitor.domain.model.PhotoModel
import com.inquisitor.domain.model.SrcModel

@JvmName(name = "photoListResponseToModel")
fun List<PhotoResponse>.mapToModel() = map { photoResponse ->
    PhotoModel(
        id = photoResponse.id ?: 0L,
        width = photoResponse.width ?: 0,
        height = photoResponse.height ?: 0,
        url = photoResponse.url ?: "",
        photographerName = photoResponse.photographerName ?: "",
        photographerUrl = photoResponse.photographerUrl ?: "",
        photographerId = photoResponse.photographerId ?: 0L,
        avgColor = photoResponse.avgColor ?: "",
        srcResponse = photoResponse.srcResponse?.mapToModel() ?: SrcModel(),
        liked = photoResponse.liked ?: false,
        alt = photoResponse.alt ?: ""
    )
}