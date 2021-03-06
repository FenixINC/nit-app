package com.inquisitor.di.qualifier

import javax.inject.Qualifier

@Retention
@Qualifier
annotation class DefaultDispatcher

@Retention
@Qualifier
annotation class IoDispatcher

@Retention
@Qualifier
annotation class MainDispatcher

@Retention
@Qualifier
annotation class MainImmediateDispatcher