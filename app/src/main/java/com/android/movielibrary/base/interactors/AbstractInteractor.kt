package com.android.movielibrary.base.interactors

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor

/**
 * Created by aamir on 12/02/18.
 */

/**
 * This abstract class define the common implementation for the child interactor. The Concrete class
 * that extends this must implements the getSingleObservable() method.
 *
 * @param threadExecutor singleton instance of Executor.
 * @param mainThread singleton instance of MainThreadScheduler.
 * */
abstract class AbstractInteractor<T>(private val executor: Executor,
                                     private val mainThreadScheduler: MainThreadScheduler) : Interactor<T> {


    private val disposables = CompositeDisposable()

    /*
    * Every Child interactor must implement their business logic in getSingleObservable(). And a Class must not
    * directly call this method instead it should call execute().
    **/
    abstract fun getSingleObservable(): Single<T>

    override fun execute(disposableSingleObserver: DisposableSingleObserver<T>) {
        getSingleObservable().subscribeOn(Schedulers.from(executor))
                .observeOn(mainThreadScheduler.scheduler)
                .subscribeWith(disposableSingleObserver)
    }

    fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}
