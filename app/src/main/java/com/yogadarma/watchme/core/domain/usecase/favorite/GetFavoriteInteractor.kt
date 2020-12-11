package com.yogadarma.watchme.core.domain.usecase.favorite

import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteInteractor(private val repository: IMovieRepository): GetFavoriteUseCase {
    override fun getAllFavorite(): Flow<List<Movie>> = repository.getAllFavorite()
}