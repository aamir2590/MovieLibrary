package com.android.movielibrary.genre.di

import com.android.movielibrary.BASE_URL
import com.android.movielibrary.base.di.customscope.ActivityScope
import com.android.movielibrary.base.interactors.AbstractInteractor
import com.android.movielibrary.genre.data.GenreRepositoryImpl
import com.android.movielibrary.genre.data.remote.GenreAPI
import com.android.movielibrary.genre.data.remote.GenreDataSource
import com.android.movielibrary.genre.data.remote.GenreNetworkDataSource
import com.android.movielibrary.genre.domain.GenreRepository
import com.android.movielibrary.genre.domain.GetMovieGenres
import com.android.movielibrary.genre.ui.GenreActivity
import com.android.movielibrary.genre.ui.GenreContract
import com.android.movielibrary.genre.ui.GenrePresenter
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
    fun provideGenreNetworkDataSource(genreAPI: GenreAPI): GenreDataSource = GenreNetworkDataSource(genreAPI)

    @Provides
    fun provideGenreService(): GenreAPI {

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build().create(GenreAPI::class.java)

    }

}
