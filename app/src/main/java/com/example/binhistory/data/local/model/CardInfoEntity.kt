package com.example.binhistory.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_history")
data class CardInfoEntity(
    @PrimaryKey val bin: String,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val countryName: String?,
    val latitude: Double?,
    val longitude: Double?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?,
    val timestamp: Long = System.currentTimeMillis()
)
