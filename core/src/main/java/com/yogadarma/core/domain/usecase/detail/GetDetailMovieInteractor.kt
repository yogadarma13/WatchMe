package com.yogadarma.core.domain.usecase.detail

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetDetailMovieInteractor(private val repository: IMovieRepository) : GetDetailMovieUseCase {
    override fun getDetailMovie(
        id: Int,
        isNowPlaying: Boolean,
        isPopular: Boolean,
        isFavorite: Boolean
    ): Flow<Resource<Movie>> =
        repository.getDetailMovie(id, isNowPlaying, isPopular, isFavorite)
}