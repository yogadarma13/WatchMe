package com.yogadarma.watchme.core.domain.usecase.tvshow

import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetNowPlayingTVShowInteractor(private val repository: IMovieRepository) :
    GetNowPlayingTVShowUseCase {

    override fun getAllNowPlayingTVShow(): Flow<Resource<List<Movie>>> = repository.getAllNowPlayingTVShow()
}