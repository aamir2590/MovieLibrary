package com.android.movielibrary.base.interactors

import android.os.Handler
import android.os.Looper

/**
 * Class is used by interactor to run a piece of code in MainThread(UI thread).
 * */
class MainThreadImpl : MainThread {

    companion object Function {

        private lateinit var sMainThreadImpl: MainThread;

        fun getInstance(): MainThread {
            if (sMainThreadImpl == null) {
                sMainThreadImpl = MainThreadImpl()
            }
            return sMainThreadImpl
        }

    }

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