package com.yogadarma.core.domain.usecase.tvshow

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetNowPlayingTVShowUseCase {

    fun getAllNowPlayingTVShow(): Flow<Resource<List<Movie>>>
}