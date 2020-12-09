package com.yogadarma.watchme.core.domain.repository

import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getAllNowPlayingMovie(): Flow<Resource<List<Movie>>>
}