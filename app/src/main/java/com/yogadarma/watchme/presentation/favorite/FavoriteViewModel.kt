package com.yogadarma.watchme.presentation.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.usecase.favorite.GetFavoriteUseCase

class FavoriteViewModel(private val getFavoriteUseCase: GetFavoriteUseCase) : ViewModel() {

    fun getAllFavorite(): LiveData<List<Movie>> = getFavoriteUseCase.getAllFavorite().asLiveData()
}