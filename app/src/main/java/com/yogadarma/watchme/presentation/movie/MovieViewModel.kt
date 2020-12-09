package com.yogadarma.watchme.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.usecase.movie.GetNowPlayingMovieUseCase

class MovieViewModel(private val getNowPlayingMovieUseCase: GetNowPlayingMovieUseCase): ViewModel() {

    fun getNowPlayingMovie(): LiveData<Resource<List<Movie>>> = getNowPlayingMovieUseCase.getNowPlayingMovie().asLiveData()
}