package com.yogadarma.watchme.core.data.source.local

import com.yogadarma.watchme.core.data.source.local.entity.MovieEntity
import com.yogadarma.watchme.core.data.source.local.room.AppDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val appDao: AppDao) {

    fun getAllNowPlayingMovie(): Flow<List<MovieEntity>> = appDao.getAllNowPlayingMovie()

    fun getAllPopularMovie(): Flow<List<MovieEntity>> = appDao.getAllPopularMovie()

    fun getAllNowPlayingTVShow(): Flow<List<MovieEntity>> = appDao.getAllNowPlayingTVShow()

    fun getAllPopularTVShow(): Flow<List<MovieEntity>> = appDao.getAllPopularTVShow()

    fun getDetail(id: Int): Flow<MovieEntity> = appDao.getDetail(id)

    suspend fun insertMovie(movies: List<MovieEntity>) = appDao.insertMovie(movies)

    fun updateMovie(movie: MovieEntity) = appDao.updateMovie(movie)

}