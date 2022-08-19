package com.example.feature_splash.elm.cmd

import com.example.feature_splash.elm.base.FlowCmdHandler
import com.example.feature_splash.elm.base.Msg
import com.example.feature_splash.elm.base.name
import com.example.feature_splash.elm.msg.OpenHomeScreenMsg
import com.example.feature_splash.elm.splash.SplashElmState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

object InitializeSplashCmd : SplashCmd {

    override fun toString(): String = name()

    @Singleton
    class Handler @Inject constructor() :
        FlowCmdHandler<InitializeSplashCmd, SplashCmd, SplashElmState> {

        override fun invoke(cmd: InitializeSplashCmd): Flow<Msg<SplashElmState, SplashCmd>> {
            return flow {
                delay(timeMillis = 2000L)
                emit(value = OpenHomeScreenMsg())
            }
        }
    }
}









