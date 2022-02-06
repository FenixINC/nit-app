package com.inquisitor.domain.mapper.pexels

import com.inquisitor.data.network.response.pexels.UserResponse
import com.inquisitor.domain.model.pexels.UserModel

fun UserResponse.mapToModel() = UserModel(
    id = this.id,
    name = this.name,
    url = this.url
)