package com.yogadarma.core.data.source.remote.network

import com.yogadarma.core.data.source.remote.response.DetailMovieResponse
import com.yogadarma.core.data.source.remote.response.DetailTVShowResponse
import com.yogadarma.core.data.source.remote.response.ListMovieResponse
import com.yogadarma.core.data.source.remote.response.ListTVShowResponse
import com.yogadarma.core.utils.Keys
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("api_key") apiKey: String = Keys.apiKey()
    ): ListMovieResponse

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = Keys.apiKey()
    ): ListMovieResponse

    @GET("tv/airing_today")
    suspend fun getNowPlayingTVShow(
        @Query("api_key") apiKey: String = Keys.apiKey()
    ): ListTVShowResponse

    @GET("tv/popular")
    suspend fun getPopularTVShow(
        @Query("api_key") apiKey: String = Keys.apiKey()
    ): ListTVShowResponse

    @GET("movie/{id}")
    suspend fun getDetailMovie(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = Keys.apiKey()
    ): DetailMovieResponse

    @GET("tv/{id}")
    suspend fun getDetailTVShow(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = Keys.apiKey()
    ): DetailTVShowResponse
}