package com.android.movielibrary.base.interactors

import io.reactivex.Scheduler

/**
 * Created by aamir on 13/02/18.
 */

/**
 * This interface will define a class that will enable interactor to getSingleObservable sum operation in MainThreadScheduler(UI).
 */
interface MainThreadScheduler {
    val scheduler: Scheduler
}