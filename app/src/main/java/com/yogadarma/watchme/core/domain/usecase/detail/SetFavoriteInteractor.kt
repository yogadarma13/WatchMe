package com.yogadarma.watchme.core.domain.usecase.detail

import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.repository.IMovieRepository

class SetFavoriteInteractor(private val repository: IMovieRepository) : SetFavoriteUseCase {
    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        repository.setFavoriteMovie(movie, state)
}