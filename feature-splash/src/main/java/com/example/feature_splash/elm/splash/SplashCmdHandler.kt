package com.example.feature_splash.elm.splash

import com.example.feature_splash.elm.base.FlowCmdHandler
import com.example.feature_splash.elm.base.Msg
import com.example.feature_splash.elm.base.SplashCmd
import com.example.feature_splash.elm.cmd.InitializeSplashCmd
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SplashCmdHandler @Inject constructor(
    private val initializeSplashCmdHandler: InitializeSplashCmd.Handler,
) : (SplashCmd) -> Flow<Msg<SplashElmState, SplashCmd>> {

    @Suppress("UNCHECKED_CAST")
    override fun invoke(cmd: SplashCmd): Flow<Msg<SplashElmState, SplashCmd>> {
        val handler = when (cmd) {
            InitializeSplashCmd -> initializeSplashCmdHandler
            else -> initializeSplashCmdHandler
        } as FlowCmdHandler<SplashCmd, SplashCmd, SplashElmState>

        return handler(cmd = cmd)
    }
}