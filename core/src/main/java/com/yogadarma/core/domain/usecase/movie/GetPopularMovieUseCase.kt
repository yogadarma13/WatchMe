package com.yogadarma.core.domain.usecase.movie

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetPopularMovieUseCase {
    fun getAllPopularMovie(): Flow<Resource<List<Movie>>>
}