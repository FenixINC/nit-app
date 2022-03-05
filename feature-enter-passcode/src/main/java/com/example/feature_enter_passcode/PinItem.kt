package com.example.feature_enter_passcode

import androidx.annotation.DrawableRes

data class PinItem(
    val type: PinType = PinType.NUMBER,
    val number: String = "",
    val iconContentDescription: String = "",
    @DrawableRes val iconDrawable: Int = -1
)