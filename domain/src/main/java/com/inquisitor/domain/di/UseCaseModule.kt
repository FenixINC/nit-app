package com.inquisitor.domain.di

import com.inquisitor.domain.usecase.*
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

    @Binds
    abstract fun provideCollectionUseCase(collectionUseCase: CollectionUseCaseImpl): CollectionUseCase

    @Binds
    abstract fun providePhotoUseCase(photoUseCase: PhotoUseCaseImpl): PhotoUseCase

    @Binds
    abstract fun provideVideoUseCase(videoUseCase: VideoUseCaseImpl): VideoUseCase
}