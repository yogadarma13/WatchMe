package com.yogadarma.core.domain.usecase.detail

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetDetailTVShowInteractor(private val repository: IMovieRepository) : GetDetailTVShowUseCase {
    override fun getDetailTVShow(
        id: Int,
        isNowPlaying: Boolean,
        isPopular: Boolean,
        isFavorite: Boolean
    ): Flow<Resource<Movie>> =
        repository.getDetailTVShow(id, isNowPlaying, isPopular, isFavorite)
}