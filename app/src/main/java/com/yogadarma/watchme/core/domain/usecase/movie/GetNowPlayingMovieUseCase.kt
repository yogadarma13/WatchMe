package com.yogadarma.watchme.core.domain.usecase.movie

import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetNowPlayingMovieUseCase {
    fun getNowPlayingMovie(): Flow<Resource<List<Movie>>>
}