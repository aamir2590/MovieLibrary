package com.android.movielibrary.base.interactors

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Class is used by interactor to getSingleObservable a piece of code in MainThreadScheduler(UI thread).
 * */
@Singleton
class MainThreadSchedulerImpl @Inject constructor() : MainThreadScheduler {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}