package com.yogadarma.watchme.core.domain.usecase.tvshow

import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetPopularTVShowInteractor(private val repository: IMovieRepository) :
    GetPopularTVShowUseCase {

    override fun getAllPopularTVShow(): Flow<Resource<List<Movie>>> =
        repository.getAllPopularTVShow()
}