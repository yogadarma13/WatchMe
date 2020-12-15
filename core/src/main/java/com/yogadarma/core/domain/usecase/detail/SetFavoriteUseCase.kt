package com.yogadarma.core.domain.usecase.detail

import com.yogadarma.core.domain.model.Movie

interface SetFavoriteUseCase {
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}