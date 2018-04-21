package com.android.movielibrary

import com.android.movielibrary.genre.data.Genre
import com.android.movielibrary.genre.data.GenresList
import com.android.movielibrary.genre.domain.GetMovieGenres
import com.android.movielibrary.genre.ui.GenreContract
import com.android.movielibrary.genre.ui.GenrePresenter
import com.nhaarman.mockito_kotlin.KArgumentCaptor
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.observers.DisposableSingleObserver
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

/**
 * Created by aamir on 18/04/18.
 */
class GenrePresenterUnitTest {

    private val ERROR_MSG = "failed to load genre list"
    private val genres: List<Genre> =
            mutableListOf(
                    Genre(1, "Thriller"),
                    Genre(2, "Action"))

    private val genresList: GenresList = GenresList(genres)

    private lateinit var view: GenreContract.View
    private lateinit var getMovieGenres: GetMovieGenres

    private lateinit var genrePresenter: GenrePresenter

    private lateinit var argumentCaptor: KArgumentCaptor<DisposableSingleObserver<GenresList>>

    @Before
    fun setUpGenrePresentUnitTest() {
        MockitoAnnotations.initMocks(this)

        view = mock()
        getMovieGenres = mock()

        argumentCaptor = argumentCaptor()
        genrePresenter = GenrePresenter(view, getMovieGenres)
    }

    @Test
    fun `notify view to show progress and execute GetMovieGenre`() {

        genrePresenter.getMovieGenre()

        verify(view).showProgress()

        verify(getMovieGenres).execute(argumentCaptor.capture())
    }

    @Test
    fun `pass Movie genre list to view and notify to hide progress`() {

        genrePresenter.getMovieGenre()

        verify(getMovieGenres).execute(argumentCaptor.capture())

        argumentCaptor.firstValue.onSuccess(genresList)
        verify(view).hideProgress()
        verify(view).showGenreList(genresList.genres)
    }

    @Test
    fun `when observers onError method invoked notify view about error`() {

        genrePresenter.getMovieGenre()

        verify(getMovieGenres).execute(argumentCaptor.capture())

        argumentCaptor.firstValue.onError(Throwable(ERROR_MSG))
        verify(view).hideProgress()
        verify(view).showErrorMsgToUser(ERROR_MSG)
    }

    @Test
    fun `ask GetMovieGenre to dispose GenreSingleDisposableObserver when presenter destroy`() {
        genrePresenter.onPresenterDestroy()
        verify(getMovieGenres).dispose()
    }
}