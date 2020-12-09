package com.yogadarma.watchme.core.data.source.remote

import com.yogadarma.watchme.core.data.source.remote.network.ApiResponse
import com.yogadarma.watchme.core.data.source.remote.network.ApiService
import com.yogadarma.watchme.core.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllNowPlayingMovie(): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getNowPlayingMovie()
                val movies = response.results
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
}