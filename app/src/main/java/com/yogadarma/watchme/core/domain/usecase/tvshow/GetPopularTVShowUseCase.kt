package com.yogadarma.watchme.core.domain.usecase.tvshow

import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetPopularTVShowUseCase {
    fun getAllPopularTVShow(): Flow<Resource<List<Movie>>>
}