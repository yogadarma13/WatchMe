package com.yogadarma.watchme.presentation.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.usecase.tvshow.GetNowPlayingTVShowUseCase
import com.yogadarma.watchme.core.domain.usecase.tvshow.GetPopularTVShowUseCase

class TvShowViewModel(
    private val getNowPlayingTVShowUseCase: GetNowPlayingTVShowUseCase,
    private val getPopularTVShowUseCase: GetPopularTVShowUseCase
) :
    ViewModel() {

    fun getAllNowPlayingTVShow(): LiveData<Resource<List<Movie>>> =
        getNowPlayingTVShowUseCase.getAllNowPlayingTVShow().asLiveData()

    fun getAllPopularTVShow(): LiveData<Resource<List<Movie>>> =
        getPopularTVShowUseCase.getAllPopularTVShow().asLiveData()
}