package com.example.binhistory.di

import com.example.binhistory.domain.usecase.GetCardHistoryUseCase
import com.example.binhistory.domain.usecase.GetCardInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {
    @Provides
    @ViewModelScoped
    fun provideGetCardInfoUseCase(repository: com.example.binhistory.domain.repository.CardRepository): GetCardInfoUseCase {
        return GetCardInfoUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetCardHistoryUseCase(repository: com.example.binhistory.domain.repository.CardRepository): GetCardHistoryUseCase {
        return GetCardHistoryUseCase(repository)
    }
}