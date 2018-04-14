package com.android.movielibrary.genre.domain

import com.android.movielibrary.base.di.customscope.ActivityScope
import com.android.movielibrary.base.interactors.AbstractInteractor
import com.android.movielibrary.base.interactors.MainThreadScheduler
import com.android.movielibrary.genre.data.GenresList
import io.reactivex.Single
import java.util.concurrent.Executor
import javax.inject.Inject

/*
 * Created by aamir on 03/04/18.
 */
@ActivityScope
class GetMovieGenres @Inject constructor(private val executor: Executor,
                                         private val mainThreadScheduler: MainThreadScheduler,
                                         private val genreRepository: GenreRepository) :
        AbstractInteractor<GenresList>(executor, mainThreadScheduler) {

    override fun getSingleObservable(): Single<GenresList> = genreRepository.getGenres()
}
