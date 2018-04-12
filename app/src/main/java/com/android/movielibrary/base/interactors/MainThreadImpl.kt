package com.android.movielibrary.base.interactors

import android.os.Handler
import android.os.Looper
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Class is used by interactor to run a piece of code in MainThread(UI thread).
 * */
@Singleton
class MainThreadImpl @Inject constructor() : MainThread {

    private val mHandler: Handler = Handler(Looper.getMainLooper());

    /**
     * This method post the runnable to be execute on MainThread(UI) using {@Link #Handler}
     *
     * @param runnable hold the logic that needs to be execute on MainThread(UI)
     * */
    override fun post(runnable: Runnable) {
        mHandler.post(runnable)
    }

}