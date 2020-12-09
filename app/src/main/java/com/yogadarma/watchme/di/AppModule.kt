package com.yogadarma.watchme.di

import com.yogadarma.watchme.core.domain.usecase.movie.GetNowPlayingMovieInteractor
import com.yogadarma.watchme.core.domain.usecase.movie.GetNowPlayingMovieUseCase
import com.yogadarma.watchme.core.domain.usecase.movie.GetPopularMovieInteractor
import com.yogadarma.watchme.core.domain.usecase.movie.GetPopularMovieUseCase
import com.yogadarma.watchme.core.domain.usecase.tvshow.GetNowPlayingTVShowInteractor
import com.yogadarma.watchme.core.domain.usecase.tvshow.GetNowPlayingTVShowUseCase
import com.yogadarma.watchme.core.domain.usecase.tvshow.GetPopularTVShowInteractor
import com.yogadarma.watchme.core.domain.usecase.tvshow.GetPopularTVShowUseCase
import com.yogadarma.watchme.presentation.movie.MovieViewModel
import com.yogadarma.watchme.presentation.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetNowPlayingMovieUseCase> { GetNowPlayingMovieInteractor(get()) }
    factory<GetPopularMovieUseCase> { GetPopularMovieInteractor(get()) }
    factory<GetNowPlayingTVShowUseCase> { GetNowPlayingTVShowInteractor(get()) }
    factory<GetPopularTVShowUseCase> { GetPopularTVShowInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get(), get()) }
    viewModel { TvShowViewModel(get(), get()) }
}