package com.inquisitor.nit.di.module

import android.content.Context
import com.inquisitor.nit.network_connection.NetworkStatusTracker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkStatusModule {

    @Provides
    fun provideNetworkStatusTracker(
        @ApplicationContext context: Context
    ): NetworkStatusTracker = NetworkStatusTracker(context = context)
}