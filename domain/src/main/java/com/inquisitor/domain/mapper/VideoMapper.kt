package com.inquisitor.domain.mapper

import com.inquisitor.data.network.response.pexels.VideoFileResponse
import com.inquisitor.data.network.response.pexels.VideoPictureResponse
import com.inquisitor.data.network.response.pexels.VideoResponse
import com.inquisitor.domain.model.UserModel
import com.inquisitor.domain.model.VideoFileModel
import com.inquisitor.domain.model.VideoModel
import com.inquisitor.domain.model.VideoPictureModel

@JvmName(name = "videoResponseListToModel")
fun List<VideoResponse>.mapToModel() = map { videoResponse ->
    VideoModel(
        id = videoResponse.id ?: 0L,
        width = videoResponse.width ?: 0,
        height = videoResponse.height ?: 0,
        duration = videoResponse.duration ?: 0,
        fullRes = videoResponse.fullRes ?: "",
        tagList = videoResponse.tagList ?: emptyList(),
        url = videoResponse.url ?: "",
        image = videoResponse.image ?: "",
        userModel = videoResponse.userResponse?.mapToModel() ?: UserModel(),
        videoFileModelList = videoResponse.videoFileResponseList?.mapToModel() ?: emptyList(),
        videoPictureModelList = videoResponse.videoPictureResponseList?.mapToModel() ?: emptyList()
    )
}

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