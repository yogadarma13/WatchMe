package com.yogadarma.watchme.core.domain.usecase.detail

import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetDetailTVShowUseCase {
    fun getDetailTVShow(
        id: Int,
        isNowPlaying: Boolean,
        isPopular: Boolean,
        isFavorite: Boolean
    ): Flow<Resource<Movie>>
}