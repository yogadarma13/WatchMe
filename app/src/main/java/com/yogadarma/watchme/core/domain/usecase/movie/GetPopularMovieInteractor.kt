package com.yogadarma.watchme.core.domain.usecase.movie

import com.yogadarma.watchme.core.data.Resource
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetPopularMovieInteractor(private val repository: IMovieRepository) : GetPopularMovieUseCase {
    override fun getAllPopularMovie(): Flow<Resource<List<Movie>>> = repository.getAllPopularMovie()
}