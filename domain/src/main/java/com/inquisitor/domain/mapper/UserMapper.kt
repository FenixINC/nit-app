package com.inquisitor.domain.mapper

import com.inquisitor.data.network.response.pexels.UserResponse
import com.inquisitor.domain.model.UserModel

fun UserResponse.mapToModel() = UserModel(
    id = this.id,
    name = this.name,
    url = this.url
)