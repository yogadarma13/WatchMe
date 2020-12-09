package com.yogadarma.watchme.core.domain.usecase.movie

import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetNowPlayingMovieInteractor(private val repository: IMovieRepository): GetNowPlayingMovieUseCase {
    override fun getNowPlayingMovie(): Flow<Resource<List<Movie>>> = repository.getAllNowPlayingMovie()
}