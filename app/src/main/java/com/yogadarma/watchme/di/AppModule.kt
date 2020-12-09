package com.yogadarma.watchme.di

import com.yogadarma.watchme.core.domain.usecase.movie.GetNowPlayingMovieInteractor
import com.yogadarma.watchme.core.domain.usecase.movie.GetNowPlayingMovieUseCase
import com.yogadarma.watchme.presentation.movie.MovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetNowPlayingMovieUseCase> { GetNowPlayingMovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
}