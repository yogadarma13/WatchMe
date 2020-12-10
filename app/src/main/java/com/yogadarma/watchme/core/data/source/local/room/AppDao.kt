package com.yogadarma.watchme.core.data.source.local.room

import androidx.room.*
import com.yogadarma.watchme.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Query("SELECT * FROM movie WHERE category = 'Movie' AND isNowPlaying = 1")
    fun getAllNowPlayingMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE category = 'Movie' AND isPopular = 1")
    fun getAllPopularMovie(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE category = 'TVShow' AND isNowPlaying = 1")
    fun getAllNowPlayingTVShow(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE category = 'TVShow' AND isPopular = 1")
    fun getAllPopularTVShow(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE movieId = :id")
    fun getDetail(id: Int) : Flow<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)
}