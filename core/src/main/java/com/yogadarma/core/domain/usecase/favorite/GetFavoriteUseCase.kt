package com.yogadarma.core.domain.usecase.favorite

import com.yogadarma.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetFavoriteUseCase {

    fun getAllFavorite(): Flow<List<Movie>>
}