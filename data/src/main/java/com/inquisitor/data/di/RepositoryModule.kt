package com.inquisitor.data.di

import com.inquisitor.data.repository.HomeRepository
import com.inquisitor.data.repository.HomeRepositoryImpl
import com.inquisitor.data.repository.LoginRepository
import com.inquisitor.data.repository.LoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun provideLoginRepository(loginRepository: LoginRepositoryImpl): LoginRepository

    @Binds
    abstract fun provideHomeRepository(homeRepository: HomeRepositoryImpl): HomeRepository
}