package com.example.binhistory.presentation.cardInfo

import com.example.binhistory.domain.model.CardInfo

data class CardInfoState(
    val isLoading: Boolean = false,
    val cardInfo: CardInfo? = null,
    val error: String? = null
)
