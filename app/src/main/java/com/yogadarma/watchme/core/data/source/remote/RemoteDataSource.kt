package com.yogadarma.watchme.core.data.source.remote

import com.yogadarma.watchme.core.data.source.remote.network.ApiResponse
import com.yogadarma.watchme.core.data.source.remote.network.ApiService
import com.yogadarma.watchme.core.data.source.remote.response.DetailMovieResponse
import com.yogadarma.watchme.core.data.source.remote.response.DetailTVShowResponse
import com.yogadarma.watchme.core.data.source.remote.response.MovieResponse
import com.yogadarma.watchme.core.data.source.remote.response.TVShowResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllNowPlayingMovie(): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getNowPlayingMovie()
                val movies = response.results!!
                if (movies.isNotEmpty()) {
                    emit(ApiResponse.Success(movies))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllPopularMovie(): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getPopularMovie()
                val movies = response.results!!
                if (movies.isNotEmpty()) {
                    emit(ApiResponse.Success(movies))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllNowPlayingTVShow(): Flow<ApiResponse<List<TVShowResponse>>> {
        return flow {
            try {
                val response = apiService.getNowPlayingTVShow()
                val tvShows = response.results!!
                if (tvShows.isNotEmpty()) {
                    emit(ApiResponse.Success(tvShows))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllPopularTVShow(): Flow<ApiResponse<List<TVShowResponse>>> {
        return flow {
            try {
                val response = apiService.getPopularTVShow()
                val tvShows = response.results!!
                if (tvShows.isNotEmpty()) {
                    emit(ApiResponse.Success(tvShows))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailMovie(id: Int): Flow<ApiResponse<DetailMovieResponse>> {
        return flow {
            try {
                val response = apiService.getDetailMovie(id)
                if (response.originalTitle!!.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailTVShow(id: Int): Flow<ApiResponse<DetailTVShowResponse>> {
        return flow {
            try {
                val response = apiService.getDetailTVShow(id)
                if (response.originalName!!.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}