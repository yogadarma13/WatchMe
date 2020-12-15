package com.yogadarma.core.domain.usecase.favorite

import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteInteractor(private val repository: IMovieRepository) : GetFavoriteUseCase {
    override fun getAllFavorite(): Flow<List<Movie>> = repository.getAllFavorite()
}