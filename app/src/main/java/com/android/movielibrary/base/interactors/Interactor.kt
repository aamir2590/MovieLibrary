package com.android.movielibrary.base.interactors

import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by aamir on 27/02/18.
 */
/*
* This interface define a signature that a class must have to become an Interactor.
* Interactor class is basically a Usecase, that is application business logic.
* */
interface Interactor<T> {
    /**
     * This the main method to start the interactor.
     */
    fun execute(disposableSingleObserver: DisposableSingleObserver<T>)
}