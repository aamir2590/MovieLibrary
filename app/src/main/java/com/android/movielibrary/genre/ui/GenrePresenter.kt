package com.android.movielibrary.genre.ui

import com.android.movielibrary.genre.data.GenresList
import com.android.movielibrary.genre.domain.GetMovieGenres
import io.reactivex.observers.DisposableSingleObserver
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
        getMovieGenres.execute(GenreSingleDisposableObserver())
    }

    override fun onPresenterDestroy() {
        getMovieGenres.dispose()
    }

    inner class GenreSingleDisposableObserver : DisposableSingleObserver<GenresList>() {

        override fun onSuccess(value: GenresList?) {
            genreView.hideProgress()
            value?.genres?.run { genreView.showGenreList(this) }
        }

        override fun onError(e: Throwable?) {
            genreView.hideProgress()
            genreView.showErrorMsgToUser(e?.message)
        }

    }
}