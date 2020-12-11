package com.yogadarma.watchme.core.domain.usecase.favorite

import com.yogadarma.watchme.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetFavoriteUseCase {

    fun getAllFavorite(): Flow<List<Movie>>
}