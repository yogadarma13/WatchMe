package com.yogadarma.watchme.di

import com.yogadarma.watchme.core.domain.usecase.detail.*
import com.yogadarma.watchme.core.domain.usecase.favorite.GetFavoriteInteractor
import com.yogadarma.watchme.core.domain.usecase.favorite.GetFavoriteUseCase
import com.yogadarma.watchme.core.domain.usecase.movie.GetNowPlayingMovieInteractor
import com.yogadarma.watchme.core.domain.usecase.movie.GetNowPlayingMovieUseCase
import com.yogadarma.watchme.core.domain.usecase.movie.GetPopularMovieInteractor
import com.yogadarma.watchme.core.domain.usecase.movie.GetPopularMovieUseCase
import com.yogadarma.watchme.core.domain.usecase.tvshow.GetNowPlayingTVShowInteractor
import com.yogadarma.watchme.core.domain.usecase.tvshow.GetNowPlayingTVShowUseCase
import com.yogadarma.watchme.core.domain.usecase.tvshow.GetPopularTVShowInteractor
import com.yogadarma.watchme.core.domain.usecase.tvshow.GetPopularTVShowUseCase
import com.yogadarma.watchme.presentation.detail.DetailViewModel
import com.yogadarma.watchme.presentation.favorite.FavoriteViewModel
import com.yogadarma.watchme.presentation.movie.MovieViewModel
import com.yogadarma.watchme.presentation.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetNowPlayingMovieUseCase> { GetNowPlayingMovieInteractor(get()) }
    factory<GetPopularMovieUseCase> { GetPopularMovieInteractor(get()) }
    factory<GetNowPlayingTVShowUseCase> { GetNowPlayingTVShowInteractor(get()) }
    factory<GetPopularTVShowUseCase> { GetPopularTVShowInteractor(get()) }
    factory<GetDetailMovieUseCase> { GetDetailMovieInteractor(get()) }
    factory<GetDetailTVShowUseCase> { GetDetailTVShowInteractor(get()) }
    factory<SetFavoriteUseCase> { SetFavoriteInteractor(get()) }
    factory<GetFavoriteUseCase> { GetFavoriteInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get(), get()) }
    viewModel { TvShowViewModel(get(), get()) }
    viewModel { DetailViewModel(get(), get(), get()) }
    viewModel { FavoriteViewModel(get()) }
}