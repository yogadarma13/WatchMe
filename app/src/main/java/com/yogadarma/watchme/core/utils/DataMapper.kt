package com.yogadarma.watchme.core.utils

import com.yogadarma.watchme.core.data.source.local.entity.MovieEntity
import com.yogadarma.watchme.core.data.source.remote.response.DetailMovieResponse
import com.yogadarma.watchme.core.data.source.remote.response.DetailTVShowResponse
import com.yogadarma.watchme.core.data.source.remote.response.MovieResponse
import com.yogadarma.watchme.core.data.source.remote.response.TVShowResponse
import com.yogadarma.watchme.core.domain.model.Movie

object DataMapper {
    fun mapMovieResponsesToEntities(
        input: List<MovieResponse>,
        isNowPlaying: Boolean = false,
        isPopular: Boolean = false
    ): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id.toString(),
                category = "Movie",
                title = it.originalTitle.toString(),
                synopsis = it.overview.toString(),
                releaseDate = it.releaseDate.toString(),
                genre = "",
                duration = "",
                rating = it.voteAverage.toString(),
                image = it.posterPath.toString(),
                isNowPlaying = isNowPlaying,
                isPopular = isPopular,
                isFavorite = false,
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapTVShowResponsesToEntities(
        input: List<TVShowResponse>,
        isNowPlaying: Boolean = false,
        isPopular: Boolean = false
    ): List<MovieEntity> {
        val tvShowList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id.toString(),
                category = "TVShow",
                title = it.originalName.toString(),
                synopsis = it.overview.toString(),
                releaseDate = it.firstAirDate.toString(),
                genre = "",
                duration = "",
                rating = it.voteAverage.toString(),
                image = it.posterPath.toString(),
                isNowPlaying = isNowPlaying,
                isPopular = isPopular,
                isFavorite = false,
            )
            tvShowList.add(movie)
        }
        return tvShowList
    }

    fun mapDetailMovieResponsesToEntities(
        input: DetailMovieResponse,
        isNowPlaying: Boolean,
        isPopular: Boolean,
        isFavorite: Boolean
    ): MovieEntity {
        return MovieEntity(
            movieId = input.id.toString(),
            category = "Movie",
            title = input.originalTitle.toString(),
            synopsis = input.overview.toString(),
            releaseDate = input.releaseDate.toString(),
            genre = input.genres!!.joinToString { it.name.toString() },
            duration = input.runtime.toString(),
            rating = input.voteAverage.toString(),
            image = input.posterPath.toString(),
            isNowPlaying = isNowPlaying,
            isPopular = isPopular,
            isFavorite = isFavorite,
        )
    }

    fun mapDetailTVShowResponsesToEntities(
        input: DetailTVShowResponse,
        isNowPlaying: Boolean,
        isPopular: Boolean,
        isFavorite: Boolean
    ): MovieEntity {
        return MovieEntity(
            movieId = input.id.toString(),
            category = "TVShow",
            title = input.originalName.toString(),
            synopsis = input.overview.toString(),
            releaseDate = input.firstAirDate.toString(),
            genre = input.genres!!.joinToString { it.name.toString() },
            duration = input.episodeRunTime!![0].toString(),
            rating = input.voteAverage.toString(),
            image = input.posterPath.toString(),
            isNowPlaying = isNowPlaying,
            isPopular = isPopular,
            isFavorite = isFavorite,
        )
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                category = it.category,
                title = it.title,
                synopsis = it.synopsis,
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

    fun mapDetailEntityToDomain(input: MovieEntity): Movie =
        Movie(
            movieId = input.movieId,
            category = input.category,
            title = input.title,
            synopsis = input.synopsis,
            releaseDate = input.releaseDate,
            genre = input.genre,
            duration = input.duration,
            rating = input.rating,
            image = input.image,
            isNowPlaying = input.isNowPlaying,
            isPopular = input.isPopular,
            isFavorite = input.isFavorite
        )


    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        category = input.category,
        title = input.title,
        synopsis = input.synopsis,
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