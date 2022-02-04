package com.inquisitor.domain.model

data class MainUserModel(
    val user: UserModel? = UserModel(),
    val profileImgUrl: String? = "",
    val address: String? = "",
    val config: String? = ""
)