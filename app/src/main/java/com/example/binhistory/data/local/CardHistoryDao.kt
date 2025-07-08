package com.example.binhistory.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.binhistory.data.local.model.CardInfoEntity

@Dao
interface CardHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(card: CardInfoEntity)

    @Query("SELECT * FROM card_history ORDER BY timestamp DESC")
    suspend fun getAll(): List<CardInfoEntity>
}