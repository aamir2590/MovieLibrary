package com.android.movielibrary.base.interactors

/**
 * Created by aamir on 27/02/18.
 */
/*
* This interface define a signature that a class must have to become an Interactor.
* Interactor class is basically a Usecase, that is application business logic.
* */
interface Interactor {
    /**
     * This the main method to start the interactor.
     */
    fun execute()
}