package com.example.feature_splash.elm.msg

import com.example.feature_splash.elm.base.Msg
import com.example.feature_splash.elm.cmd.SplashCmd
import com.example.feature_splash.elm.base.Update
import com.example.feature_splash.elm.base.asUpdate
import com.example.feature_splash.elm.cmd.InitializeSplashCmd
import com.example.feature_splash.elm.splash.SplashElmState

class InitializeSplashMsg : Msg<SplashElmState, SplashCmd> {
    override fun invoke(state: SplashElmState): Update<SplashElmState, SplashCmd> {
        return state.asUpdate(command = InitializeSplashCmd)
    }
}