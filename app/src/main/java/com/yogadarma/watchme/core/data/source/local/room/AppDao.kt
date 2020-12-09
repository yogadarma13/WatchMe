package com.yogadarma.watchme.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yogadarma.watchme.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Query("SELECT * FROM movie WHERE category = 'Movie' AND isNowPlaying = 1")
    fun getAllNowPlayingMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE category = 'Movie' AND isPopular = 1")
    fun getAllPopularMovie(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: List<MovieEntity>)
}