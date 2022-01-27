package com.inquisitor.domain.di

import com.inquisitor.domain.usecase.HomeUseCase
import com.inquisitor.domain.usecase.HomeUseCaseImpl
import com.inquisitor.domain.usecase.LoginUseCase
import com.inquisitor.domain.usecase.LoginUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class UseCaseModule {

    @Binds
    abstract fun provideLoginUseCase(loginUseCase: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun provideHomeUseCase(homeUseCase: HomeUseCaseImpl): HomeUseCase
}