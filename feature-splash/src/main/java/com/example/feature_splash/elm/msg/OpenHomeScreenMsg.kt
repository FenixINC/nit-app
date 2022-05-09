package com.example.feature_splash.elm.msg

import com.example.feature_splash.elm.base.Msg
import com.example.feature_splash.elm.base.SplashCmd
import com.example.feature_splash.elm.base.Update
import com.example.feature_splash.elm.base.asUpdate
import com.example.feature_splash.elm.splash.SplashElmState

class OpenHomeScreenMsg : Msg<SplashElmState, SplashCmd> {
    override fun invoke(state: SplashElmState): Update<SplashElmState, SplashCmd> {
        return state.copy(isNavigateToHome = true).asUpdate()
    }
}