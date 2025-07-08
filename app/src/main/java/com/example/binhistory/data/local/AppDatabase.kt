package com.example.binhistory.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.binhistory.data.local.model.CardInfoEntity

@Database(entities = [CardInfoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cardHistoryDao(): CardHistoryDao
}