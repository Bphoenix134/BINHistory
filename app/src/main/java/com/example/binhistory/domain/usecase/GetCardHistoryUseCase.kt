package com.example.binhistory.domain.usecase

import com.example.binhistory.domain.model.CardInfo
import com.example.binhistory.domain.repository.CardRepository
import javax.inject.Inject

class GetCardInfoUseCase @Inject constructor(
    private val repository: CardRepository
) {
    suspend operator fun invoke(bin: String): Result<CardInfo> {
        val result = repository.getCardInfo(bin)
        if (result.isSuccess) {
            repository.saveCardInfo(result.getOrNull()!!)
        }
        return result
    }
}