package com.android.movielibrary.base.interactors

/**
 * Created by aamir on 13/02/18.
 */

/**
 * This interface will define a class that will enable interactor to run sum operation in MainThread(UI).
 */
interface MainThread {

    /**
     * Make the runnable run in main thread.
     * */
    fun post(runnable: Runnable)
}