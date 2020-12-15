package com.yogadarma.core.domain.usecase.detail

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetDetailMovieUseCase {
    fun getDetailMovie(
        id: Int,
        isNowPlaying: Boolean,
        isPopular: Boolean,
        isFavorite: Boolean
    ): Flow<Resource<Movie>>
}