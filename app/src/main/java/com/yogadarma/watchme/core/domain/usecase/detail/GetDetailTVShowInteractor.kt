package com.yogadarma.watchme.core.domain.usecase.detail

import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetDetailTVShowInteractor(private val repository: IMovieRepository): GetDetailTVShowUseCase {
    override fun getDetailTVShow(
        id: Int,
        isNowPlaying: Boolean,
        isPopular: Boolean,
        isFavorite: Boolean
    ): Flow<Resource<Movie>> =
        repository.getDetailTVShow(id, isNowPlaying, isPopular, isFavorite)
}