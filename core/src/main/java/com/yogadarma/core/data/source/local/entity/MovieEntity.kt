package com.yogadarma.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "synopsis")
    var synopsis: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "isNowPlaying")
    var isNowPlaying: Boolean = false,

    @ColumnInfo(name = "isPopular")
    var isPopular: Boolean = false,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)