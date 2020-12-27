package com.yogadarma.core.data.source.remote

import android.content.Context
import com.yogadarma.core.R
import com.yogadarma.core.data.source.remote.network.ApiResponse
import com.yogadarma.core.data.source.remote.network.ApiService
import com.yogadarma.core.data.source.remote.response.DetailMovieResponse
import com.yogadarma.core.data.source.remote.response.DetailTVShowResponse
import com.yogadarma.core.data.source.remote.response.MovieResponse
import com.yogadarma.core.data.source.remote.response.TVShowResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class RemoteDataSource(private val apiService: ApiService, private val context: Context) {

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
                Timber.e(e.message.toString())
                emit(ApiResponse.Error(context.getString(R.string.error_now_playing_movie)))
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
                Timber.e(e.message.toString())
                emit(ApiResponse.Error(context.getString(R.string.error_popular_movie)))
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
                Timber.e(e.message.toString())
                emit(ApiResponse.Error(context.getString(R.string.error_now_playing_tv_show)))
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
                Timber.e(e.message.toString())
                emit(ApiResponse.Error(context.getString(R.string.error_popular_tv_show)))
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
                Timber.e(e.message.toString())
                emit(ApiResponse.Error(context.getString(R.string.error_detail)))
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
                Timber.e(e.message.toString())
                emit(ApiResponse.Error(context.getString(R.string.error_detail)))
            }
        }.flowOn(Dispatchers.IO)
    }
}