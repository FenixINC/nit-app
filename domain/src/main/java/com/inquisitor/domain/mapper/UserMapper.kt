package com.inquisitor.domain.mapper

import com.inquisitor.data.network.response.open_sea_nft.MainUserResponse
import com.inquisitor.domain.model.MainUserModel
import com.inquisitor.domain.model.UserModel

fun MainUserResponse.mapToModel() = MainUserModel(
    user = UserModel(username = this.user?.username),
    profileImgUrl = this.profileImgUrl,
    address = this.address,
    config = this.config
)