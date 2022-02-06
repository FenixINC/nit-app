package com.inquisitor.domain.mapper

import com.inquisitor.data.network.response.pexels.PhotoResponse
import com.inquisitor.domain.model.PhotoModel

fun List<PhotoResponse>.mapToModel() = map { photoResponse ->
    PhotoModel(
        id = photoResponse.id,
        width = photoResponse.width,
        height = photoResponse.height,
        url = photoResponse.url,
        photographerName = photoResponse.photographerName,
        photographerUrl = photoResponse.photographerUrl,
        photographerId = photoResponse.photographerId,
        avgColor = photoResponse.avgColor,
        srcResponse = photoResponse.srcResponse?.mapToModel(),
        liked = photoResponse.liked,
        alt = photoResponse.alt
    )
}