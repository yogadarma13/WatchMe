package com.yogadarma.watchme.core.domain.usecase.movie

import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetPopularMovieUseCase {
    fun getAllPopularMovie(): Flow<Resource<List<Movie>>>
}