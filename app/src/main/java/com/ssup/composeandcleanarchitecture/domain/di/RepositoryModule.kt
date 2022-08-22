package com.ssup.composeandcleanarchitecture.domain.di

import com.ssup.composeandcleanarchitecture.data.network.DataService
import com.ssup.composeandcleanarchitecture.presentation.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @ViewModelScoped
    @Provides
    fun provideMainRepository(dataService: DataService): MainRepository {
        return MainRepository(dataService = dataService)
    }
}