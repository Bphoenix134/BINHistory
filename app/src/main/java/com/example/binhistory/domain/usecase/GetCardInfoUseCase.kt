package com.example.binhistory.domain.usecase

import com.example.binhistory.domain.model.CardInfo
import com.example.binhistory.domain.repository.CardRepository
import javax.inject.Inject

class GetCardHistoryUseCase @Inject constructor(
    private val repository: CardRepository
) {
    suspend operator fun invoke(): List<CardInfo> {
        return repository.getCardHistory()
    }
}