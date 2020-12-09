package com.yogadarma.watchme.core.utils

import com.yogadarma.watchme.core.data.source.local.entity.MovieEntity
import com.yogadarma.watchme.core.data.source.remote.response.MovieResponse
import com.yogadarma.watchme.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(
        input: List<MovieResponse>,
        category: String,
        isNowPlaying: Boolean = false,
        isPopular: Boolean = false
    ): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id.toString(),
                category = category,
                title = it.originalTitle,
                description = it.overview,
                releaseDate = it.releaseDate,
                genre = "",
                duration = "",
                rating = it.voteAverage.toString(),
                image = it.posterPath,
                isNowPlaying = isNowPlaying,
                isPopular = isPopular,
                isFavorite = false,
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                category = it.category,
                title = it.title,
                description = it.description,
                releaseDate = it.releaseDate,
                genre = it.genre,
                duration = it.duration,
                rating = it.rating,
                image = it.image,
                isNowPlaying = it.isNowPlaying,
                isPopular = it.isPopular,
                isFavorite = it.isFavorite,
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        category = input.category,
        title = input.title,
        description = input.description,
        releaseDate = input.releaseDate,
        genre = input.genre,
        duration = input.duration,
        rating = input.rating,
        image = input.image,
        isNowPlaying = input.isNowPlaying,
        isPopular = input.isPopular,
        isFavorite = input.isFavorite,
    )
}