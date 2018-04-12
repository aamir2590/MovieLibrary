package com.android.movielibrary.genre.domain

import com.android.movielibrary.base.di.customscope.ActivityScope
import com.android.movielibrary.base.interactors.AbstractInteractor
import com.android.movielibrary.base.interactors.Executor
import com.android.movielibrary.base.interactors.MainThread
import javax.inject.Inject

/*
 * Created by aamir on 03/04/18.
 */
@ActivityScope
class GetMovieGenres @Inject constructor(private val threadExecutor: Executor,
                                         private val mainThread: MainThread,
                                         private val genreRepository: GenreRepository) :
        AbstractInteractor(threadExecutor) {

    override fun run() {
        genreRepository.getGenres()
    }
}
