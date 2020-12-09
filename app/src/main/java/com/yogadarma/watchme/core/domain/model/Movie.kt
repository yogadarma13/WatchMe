package com.yogadarma.watchme.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val movieId: String,
    val category: String,
    val title: String,
    val genre: String,
    val description: String,
    val releaseDate: String,
    val rating: String,
    val duration: String,
    val image: String,
    val isNowPlaying: Boolean,
    val isPopular: Boolean,
    val isFavorite: Boolean
): Parcelable