package com.example.binhistory.domain.repository

import com.example.binhistory.domain.model.CardInfo

interface CardRepository {
    suspend fun getCardInfo(bin: String): Result<CardInfo>
    suspend fun getCardHistory(): List<CardInfo>
    suspend fun saveCardInfo(cardInfo: CardInfo)
}