package com.yogadarma.core.domain.usecase.detail

import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.repository.IMovieRepository

class SetFavoriteInteractor(private val repository: IMovieRepository) : SetFavoriteUseCase {
    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        repository.setFavoriteMovie(movie, state)
}