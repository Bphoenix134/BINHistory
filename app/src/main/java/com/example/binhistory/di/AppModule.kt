package com.example.binhistory.di

import com.example.binhistory.data.api.BinApiService
import com.example.binhistory.data.local.CardHistoryDao
import com.example.binhistory.data.repository.CardRepositoryImpl
import com.example.binhistory.domain.repository.CardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCardRepository(
        apiService: BinApiService,
        dao: CardHistoryDao
    ): CardRepository {
        return CardRepositoryImpl(apiService, dao)
    }
}