package com.example.binhistory.domain.model

data class CardInfo (
    val bin: String,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val countryName: String?,
    val latitude: Double?,
    val longitude: Double?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?
)