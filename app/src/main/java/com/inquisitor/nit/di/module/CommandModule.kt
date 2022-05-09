package com.inquisitor.nit.di.module

import com.example.feature_splash.elm.base.FlowCmdHandler
import com.example.feature_splash.elm.cmd.InitializeSplashCmd
import com.example.feature_splash.elm.base.SplashCmd
import com.example.feature_splash.elm.splash.SplashElmState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) // TODO: Rewrite to another component (not Singleton)
object CommandModule {

    @Provides
    fun provideInitializeSplashCmdHandler(): FlowCmdHandler<InitializeSplashCmd, SplashCmd, SplashElmState> =
        InitializeSplashCmd.Handler()
}