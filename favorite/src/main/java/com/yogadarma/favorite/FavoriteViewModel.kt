package com.yogadarma.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.usecase.favorite.GetFavoriteUseCase

class FavoriteViewModel(private val getFavoriteUseCase: GetFavoriteUseCase): ViewModel() {
    fun getAllFavorite(): LiveData<List<Movie>> = getFavoriteUseCase.getAllFavorite().asLiveData()
}