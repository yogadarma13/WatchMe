package com.yogadarma.core.domain.usecase.movie

import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class GetPopularMovieInteractor(private val repository: IMovieRepository) : GetPopularMovieUseCase {
    override fun getAllPopularMovie(): Flow<Resource<List<Movie>>> = repository.getAllPopularMovie()
}