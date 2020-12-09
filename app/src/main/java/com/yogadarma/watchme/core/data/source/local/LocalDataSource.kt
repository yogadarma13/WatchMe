package com.yogadarma.watchme.core.data.source.local

import com.yogadarma.watchme.core.data.source.local.entity.MovieEntity
import com.yogadarma.watchme.core.data.source.local.room.AppDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val appDao: AppDao) {

    fun getAllNowPlayingMovie(): Flow<List<MovieEntity>> = appDao.getAllNowPlayingMovie()

    suspend fun insertMovie(movies: List<MovieEntity>) = appDao.insertMovie(movies)

}