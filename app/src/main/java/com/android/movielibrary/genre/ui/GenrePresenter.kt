package com.android.movielibrary.genre.ui

import com.android.movielibrary.genre.domain.GetMovieGenres
import javax.inject.Inject

/*
 * Created by aamir on 30/03/18.
 */
class GenrePresenter @Inject constructor(val genreView: GenreContract.View,
                                         val getMovieGenres: GetMovieGenres)
    : GenreContract.Presenter {

    init {
        genreView.setPresenter(this)
    }

    override fun getMovieGenre() {
        genreView.showProgress()
        getMovieGenres.execute()
    }
}