package com.yogadarma.core.domain.usecase.movie

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetNowPlayingMovieInteractor(private val repository: IMovieRepository) :
    GetNowPlayingMovieUseCase {
    override fun getAllNowPlayingMovie(): Flow<Resource<List<Movie>>> =
        repository.getAllNowPlayingMovie()
}