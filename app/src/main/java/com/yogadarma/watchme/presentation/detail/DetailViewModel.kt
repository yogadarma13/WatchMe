package com.yogadarma.watchme.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.usecase.detail.GetDetailMovieUseCase
import com.yogadarma.watchme.core.domain.usecase.detail.GetDetailTVShowUseCase

class DetailViewModel(
    private val getDetailMovieUseCase: GetDetailMovieUseCase,
    private val getDetailTVShowUseCase: GetDetailTVShowUseCase
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

}