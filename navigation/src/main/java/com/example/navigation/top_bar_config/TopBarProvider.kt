package com.example.navigation.top_bar_config

data class TopBarProvider(
    val topBarType: TopBarType = TopBarType.EMPTY,
    val topBarLoginConfig: TopBarLoginConfig = TopBarLoginConfig(),
    val topBarHomeConfig: TopBarHomeConfig = TopBarHomeConfig()
)