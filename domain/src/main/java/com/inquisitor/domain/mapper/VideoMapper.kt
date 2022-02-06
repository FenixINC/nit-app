package com.inquisitor.domain.mapper

import com.inquisitor.data.network.response.pexels.VideoFileResponse
import com.inquisitor.data.network.response.pexels.VideoPictureResponse
import com.inquisitor.domain.model.VideoFileModel
import com.inquisitor.domain.model.VideoPictureModel

@JvmName(name = "videoFileResponseListToModel")
fun List<VideoFileResponse>.mapToModel() = map { videoFileResponse ->
    VideoFileModel(
        id = videoFileResponse.id,
        quality = videoFileResponse.quality,
        fileType = videoFileResponse.fileType,
        width = videoFileResponse.width,
        height = videoFileResponse.height,
        link = videoFileResponse.link
    )
}

@JvmName(name = "videoPictureResponseListToModel")
fun List<VideoPictureResponse>.mapToModel() = map { videoPictureResponse ->
    VideoPictureModel(
        id = videoPictureResponse.id,
        nr = videoPictureResponse.nr,
        picture = videoPictureResponse.picture
    )
}