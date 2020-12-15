package com.yogadarma.watchme.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.usecase.detail.GetDetailMovieUseCase
import com.yogadarma.core.domain.usecase.detail.GetDetailTVShowUseCase
import com.yogadarma.core.domain.usecase.detail.SetFavoriteUseCase

class DetailViewModel(
    private val getDetailMovieUseCase: GetDetailMovieUseCase,
    private val getDetailTVShowUseCase: GetDetailTVShowUseCase,
    private var setFavoriteUseCase: SetFavoriteUseCase
) : ViewModel() {

    fun getDetail(
        id: Int,
        category: String,
        isNowPlaying: Boolean,
        isPopular: Boolean,
        isFavorite: Boolean
    ): LiveData<Resource<Movie>> =
        if (category == "Movie")
            getDetailMovieUseCase.getDetailMovie(
                id,
                isNowPlaying,
                isPopular,
                isFavorite
            ).asLiveData()
        else
            getDetailTVShowUseCase.getDetailTVShow(
                id,
                isNowPlaying,
                isPopular,
                isFavorite
            ).asLiveData()

    fun setFavoriteMovie(movie: Movie, state: Boolean) =
        setFavoriteUseCase.setFavoriteMovie(movie, state)
}