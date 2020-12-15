package com.yogadarma.core.domain.usecase.tvshow

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetPopularTVShowInteractor(private val repository: IMovieRepository) :
    GetPopularTVShowUseCase {

    override fun getAllPopularTVShow(): Flow<Resource<List<Movie>>> =
        repository.getAllPopularTVShow()
}