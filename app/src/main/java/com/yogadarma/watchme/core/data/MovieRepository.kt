package com.yogadarma.watchme.core.data

import com.yogadarma.watchme.core.data.source.local.LocalDataSource
import com.yogadarma.watchme.core.data.source.remote.RemoteDataSource
import com.yogadarma.watchme.core.data.source.remote.network.ApiResponse
import com.yogadarma.watchme.core.data.source.remote.response.MovieResponse
import com.yogadarma.watchme.core.data.source.remote.response.TVShowResponse
import com.yogadarma.watchme.core.domain.model.Movie
import com.yogadarma.watchme.core.domain.repository.IMovieRepository
import com.yogadarma.watchme.core.utils.AppExecutors
import com.yogadarma.watchme.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {
    override fun getAllNowPlayingMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllNowPlayingMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllNowPlayingMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList =
                    DataMapper.mapMovieResponsesToEntities(data, isNowPlaying = true)
                localDataSource.insertMovie(movieList)
            }

        }.asFlow()

    override fun getAllPopularMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllPopularMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllPopularMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList =
                    DataMapper.mapMovieResponsesToEntities(data, isPopular = true)
                localDataSource.insertMovie(movieList)
            }

        }.asFlow()

    override fun getAllNowPlayingTVShow(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<TVShowResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllNowPlayingTVShow().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<TVShowResponse>>> =
                remoteDataSource.getAllNowPlayingTVShow()

            override suspend fun saveCallResult(data: List<TVShowResponse>) {
                val tvShowList = DataMapper.mapTVShowResponsesToEntities(data, isNowPlaying = true)
                localDataSource.insertMovie(tvShowList)
            }

        }.asFlow()
}