package com.yogadarma.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yogadarma.core.data.source.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao
}