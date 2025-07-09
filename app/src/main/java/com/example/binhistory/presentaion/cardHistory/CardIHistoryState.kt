package com.example.binhistory.presentaion.cardHistory

import com.example.binhistory.domain.model.CardInfo

data class CardHistoryState(
    val cards: List<CardInfo> = emptyList()
)
