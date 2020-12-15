package com.yogadarma.core.domain.repository

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllNowPlayingMovie(): Flow<Resource<List<Movie>>>

    fun getAllPopularMovie(): Flow<Resource<List<Movie>>>

    fun getAllNowPlayingTVShow(): Flow<Resource<List<Movie>>>

    fun getAllPopularTVShow(): Flow<Resource<List<Movie>>>

    fun getDetailMovie(
        id: Int,
        isNowPlaying: Boolean,
        isPopular: Boolean,
        isFavorite: Boolean
    ): Flow<Resource<Movie>>

    fun getDetailTVShow(
        id: Int,
        isNowPlaying: Boolean,
        isPopular: Boolean,
        isFavorite: Boolean
    ): Flow<Resource<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

    fun getAllFavorite(): Flow<List<Movie>>
}