package com.android.movielibrary.genre.di

import com.android.movielibrary.base.di.customscope.ActivityScope
import com.android.movielibrary.base.interactors.AbstractInteractor
import com.android.movielibrary.genre.data.GenreRepositoryImpl
import com.android.movielibrary.genre.data.remote.GenreDataSource
import com.android.movielibrary.genre.data.remote.GenreNetworkDataSource
import com.android.movielibrary.genre.domain.GenreRepository
import com.android.movielibrary.genre.domain.GetMovieGenres
import com.android.movielibrary.genre.ui.GenreActivity
import com.android.movielibrary.genre.ui.GenreContract
import com.android.movielibrary.genre.ui.GenrePresenter
import dagger.Module
import dagger.Provides

/*
 * Created by aamir on 01/04/18.
 */

@Module
class GenreActivityModule {

    @Provides
    @ActivityScope
    fun provideGenreView(genreActivity: GenreActivity): GenreContract.View = genreActivity

    @Provides
    @ActivityScope
    fun provideGenrePresenter(genreView: GenreContract.View, getMovieGenres: GetMovieGenres):
            GenreContract.Presenter = GenrePresenter(genreView, getMovieGenres)

    @Provides
    @ActivityScope
    fun provideGetGenreInteractor(getMovieGenres: GetMovieGenres): AbstractInteractor = getMovieGenres

    @Provides
    @ActivityScope
    fun provideGenreRepository(genreDataSource: GenreDataSource): GenreRepository = GenreRepositoryImpl(genreDataSource)

    @Provides
    @ActivityScope
    fun provideGenreNetworkDataSource(): GenreDataSource = GenreNetworkDataSource()

}
