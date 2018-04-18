package com.android.movielibrary

import com.android.movielibrary.base.interactors.MainThreadScheduler
import com.android.movielibrary.genre.data.Genre
import com.android.movielibrary.genre.data.GenresList
import com.android.movielibrary.genre.domain.GenreRepository
import com.android.movielibrary.genre.domain.GetMovieGenres
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
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

    @Before
    fun setUpGetMovieGenreUnitTest() {

        MockitoAnnotations.initMocks(this)

        repository = mock()

        mainThreadScheduler = mock()

        executor = mock()

        getMovieGenres = GetMovieGenres(executor, mainThreadScheduler, repository)

    }

    @Test
    fun singleObservableFromRepositoryCompletes() {
        whenever(repository.getGenres()).thenReturn(Single.just(genresList))
        val testObserver = getMovieGenres.getSingleObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getSingleObservableFromRepositoryReturnsValues() {
        whenever(repository.getGenres()).thenReturn(Single.just(genresList))
        val testObserver = getMovieGenres.getSingleObservable().test()
        testObserver.assertValue(genresList)
    }
}