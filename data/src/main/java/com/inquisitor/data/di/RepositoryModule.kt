package com.inquisitor.data.di

import com.inquisitor.data.repository.*
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

    @Binds
    abstract fun provideCollectionRepository(collectionRepository: CollectionRepositoryImpl): CollectionRepository

    @Binds
    abstract fun providePhotoRepository(photoRepository: PhotoRepositoryImpl): PhotoRepository

    @Binds
    abstract fun provideVideoRepository(videoRepository: VideoRepositoryImpl): VideoRepository
}