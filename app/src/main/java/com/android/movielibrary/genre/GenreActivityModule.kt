package com.android.movielibrary.genre

import dagger.Module
import dagger.Provides

/*
 * Created by aamir on 01/04/18.
 */

@Module
class GenreActivityModule {

    @Provides
    fun provideGenreView(genreActivity: GenreActivity): GenreContract.View = genreActivity

    @Provides
    fun provideGenrePresenter(genreView: GenreContract.View): GenreContract.Presenter = GenrePresenter(genreView)

}
