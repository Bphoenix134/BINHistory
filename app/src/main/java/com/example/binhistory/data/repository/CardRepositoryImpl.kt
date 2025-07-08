package com.example.binhistory.data.repository

import com.example.binhistory.data.api.BinApiService
import com.example.binhistory.data.local.CardHistoryDao
import com.example.binhistory.domain.repository.CardRepository
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val apiService: BinApiService,
    private val dao: CardHistoryDao
) : CardRepository {
    override suspend fun getCardInfo(bin: String): Result<CardInfo> {
        return try {
            val response = apiService.getCardInfo(bin)
            val cardInfo = response.toDomain(bin)
            Result.success(cardInfo)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCardHistory(): List<CardInfo> {
        return dao.getAll().map { it.toDomain() }
    }

    override suspend fun saveCardInfo(cardInfo: CardInfo) {
        dao.insert(cardInfo.toEntity())
    }
}