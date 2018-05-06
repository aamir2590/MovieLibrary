package com.android.movielibrary.genre.ui

import com.android.movielibrary.base.ui.BasePresenter
import com.android.movielibrary.base.ui.BaseView
import com.android.movielibrary.genre.data.Genre

/*
 * Created by aamir on 30/03/18.
 */
class GenreContract {
    interface Presenter : BasePresenter<GenreActivity> {
        fun getMovieGenre()
    }

    interface View : BaseView<Presenter> {
        fun showProgress()
        fun hideProgress()
        fun showGenreList(genreList: List<Genre>)
        fun showErrorMsgToUser(errorMsg: String?)
    }
}