package com.yogadarma.watchme.di

import com.yogadarma.core.domain.usecase.detail.*
import com.yogadarma.core.domain.usecase.favorite.GetFavoriteInteractor
import com.yogadarma.core.domain.usecase.favorite.GetFavoriteUseCase
import com.yogadarma.core.domain.usecase.movie.GetNowPlayingMovieInteractor
import com.yogadarma.core.domain.usecase.movie.GetNowPlayingMovieUseCase
import com.yogadarma.core.domain.usecase.movie.GetPopularMovieInteractor
import com.yogadarma.core.domain.usecase.movie.GetPopularMovieUseCase
import com.yogadarma.core.domain.usecase.tvshow.GetNowPlayingTVShowInteractor
import com.yogadarma.core.domain.usecase.tvshow.GetNowPlayingTVShowUseCase
import com.yogadarma.core.domain.usecase.tvshow.GetPopularTVShowInteractor
import com.yogadarma.core.domain.usecase.tvshow.GetPopularTVShowUseCase
import com.yogadarma.watchme.presentation.detail.DetailViewModel
import com.yogadarma.watchme.presentation.movie.MovieViewModel
import com.yogadarma.watchme.presentation.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single<GetNowPlayingMovieUseCase> { GetNowPlayingMovieInteractor(get()) }
    single<GetPopularMovieUseCase> { GetPopularMovieInteractor(get()) }
    single<GetNowPlayingTVShowUseCase> { GetNowPlayingTVShowInteractor(get()) }
    single<GetPopularTVShowUseCase> { GetPopularTVShowInteractor(get()) }
    single<GetDetailMovieUseCase> { GetDetailMovieInteractor(get()) }
    single<GetDetailTVShowUseCase> { GetDetailTVShowInteractor(get()) }
    single<SetFavoriteUseCase> { SetFavoriteInteractor(get()) }
    single<GetFavoriteUseCase> { GetFavoriteInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get(), get()) }
    viewModel { TvShowViewModel(get(), get()) }
    viewModel { DetailViewModel(get(), get(), get()) }
}