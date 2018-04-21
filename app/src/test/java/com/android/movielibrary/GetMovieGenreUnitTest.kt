package com.android.movielibrary

import com.android.movielibrary.base.interactors.MainThreadScheduler
import com.android.movielibrary.genre.data.Genre
import com.android.movielibrary.genre.data.GenresList
import com.android.movielibrary.genre.domain.GenreRepository
import com.android.movielibrary.genre.domain.GetMovieGenres
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import java.util.concurrent.Executor

/*
 * Created by aamir on 15/04/18.
 */
class GetMovieGenreUnitTest {

    private val genres: List<Genre> = mutableListOf(Genre(1, "Thriller"), Genre(2, "Action"))

    private val genresList: GenresList = GenresList(genres)

    private lateinit var executor: Executor

    private lateinit var mainThreadScheduler: MainThreadScheduler

    private lateinit var repository: GenreRepository

    private lateinit var getMovieGenres: GetMovieGenres

    private lateinit var disposableSingleObserver: DisposableSingleObserver<GenresList>

    @Before
    fun setUpGetMovieGenreUnitTest() {

        MockitoAnnotations.initMocks(this)

        repository = mock()

        mainThreadScheduler = mock()

        executor = mock()

        disposableSingleObserver = mock()

        getMovieGenres = GetMovieGenres(executor, mainThreadScheduler, repository)

    }

    @Test
    fun `is genreList's observer completes successfully`() {
        whenever(repository.getGenres()).thenReturn(Single.just(genresList))
        val testObserver = getMovieGenres.getSingleObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun `is genreList's observer receives same list what genre repository observable is emitting`() {
        whenever(repository.getGenres()).thenReturn(Single.just(genresList))
        val testObserver = getMovieGenres.getSingleObservable().test()
        testObserver.assertValue(genresList)
    }

    @Test
    fun `is disposableObserver gets added in the disposable list`() {

        whenever(getMovieGenres.getSingleObservable()).thenReturn(Single.just(genresList))

        whenever(mainThreadScheduler.scheduler).thenReturn(Schedulers.trampoline())

        getMovieGenres.execute(disposableSingleObserver)

        assertTrue(getMovieGenres.compositeDisposableSize() == 1)

    }
}