package com.inquisitor.domain.mapper.pexels

import com.inquisitor.data.network.response.pexels.MediaResponse
import com.inquisitor.domain.model.pexels.MediaModel

fun MediaResponse.mapToModel() = MediaModel(
    id = this.id,
    type = this.type,
    width = this.width,
    height = this.height,
    url = this.url,
    photographerName = this.photographerName,
    photographerUrl = this.photographerUrl,
    photographerId = this.photographerId,
    avgColor = this.avgColor,
    srcModel = this.srcResponse?.mapToModel(),
    liked = this.liked,
    alt = this.alt,
    duration = this.duration,
    fullRes = this.fullRes,
    tagList = this.tagList,
    image = this.image,
    userModel = this.userResponse?.mapToModel(),
    videoFileList = this.videoFileResponseList?.mapToModel(),
    videoPictureList = this.videoPictureResponseList?.mapToModel()
)

fun List<MediaResponse>.mapToModel() = map { mediaResponse ->
    mediaResponse.mapToModel()
}