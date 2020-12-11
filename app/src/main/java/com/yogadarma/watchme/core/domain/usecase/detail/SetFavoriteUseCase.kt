package com.yogadarma.watchme.core.domain.usecase.detail

import com.yogadarma.watchme.core.domain.model.Movie

interface SetFavoriteUseCase {
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}