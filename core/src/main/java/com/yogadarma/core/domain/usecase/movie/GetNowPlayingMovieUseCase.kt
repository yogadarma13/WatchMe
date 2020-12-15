package com.yogadarma.core.domain.usecase.movie

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetNowPlayingMovieUseCase {
    fun getAllNowPlayingMovie(): Flow<Resource<List<Movie>>>
}