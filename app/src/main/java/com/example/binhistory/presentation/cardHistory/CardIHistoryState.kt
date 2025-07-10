package com.example.binhistory.presentation.cardHistory

import com.example.binhistory.domain.model.CardInfo

data class CardHistoryState(
    val cards: List<CardInfo> = emptyList()
)
