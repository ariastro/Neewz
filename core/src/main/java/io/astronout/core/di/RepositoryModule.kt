package io.astronout.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.astronout.core.data.source.NeewzRepositoryImpl
import io.astronout.core.data.source.local.LocalDataSource
import io.astronout.core.data.source.local.LocalDataSourceImpl
import io.astronout.core.data.source.remote.RemoteDataSource
import io.astronout.core.data.source.remote.RemoteDataSourceImpl
import io.astronout.core.domain.repository.NeewzRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @Singleton
    abstract fun bindRepository(neewzRepositoryImpl: NeewzRepositoryImpl): NeewzRepository

}