package com.yogadarma.watchme.core.data.source.remote.network

import com.yogadarma.watchme.core.data.source.remote.response.ListMovieResponse
import com.yogadarma.watchme.core.data.source.remote.response.ListTVShowResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): ListMovieResponse

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): ListMovieResponse

    @GET("tv/airing_today")
    suspend fun getNowPlayingTVShow(
        @Query("api_key") apiKey: String = Constant.API_KEY
    ): ListTVShowResponse
}