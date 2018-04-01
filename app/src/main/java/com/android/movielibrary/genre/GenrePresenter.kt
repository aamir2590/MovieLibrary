package com.android.movielibrary.genre

import javax.inject.Inject

/*
 * Created by aamir on 30/03/18.
 */
class GenrePresenter @Inject constructor(val genreView: GenreContract.View) : GenreContract.Presenter {

    init {
        genreView.setPresenter(this)
    }
}