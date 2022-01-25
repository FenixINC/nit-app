package com.inquisitor.di.module

import com.inquisitor.data.repository.LoginRepositoryImpl
import com.inquisitor.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkModule {
    
    @Binds
    abstract fun provideLoginRepository(loginRepository: LoginRepositoryImpl): LoginRepository
}