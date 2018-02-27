package com.android.movielibrary.base.interactors

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * Created by aamir on 12/02/18.
 */
class ThreadExecutor : Executor {

    companion object {
        private val sThereadExecutor: ThreadExecutor? = null
        fun getInstance(): ThreadExecutor {
            return ThreadExecutor()
        }
    }

    private val mThreadPoolExecutor: ThreadPoolExecutor
    private val CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private val MAX_POOL_SIZE = 2 * Runtime.getRuntime().availableProcessors() + 1
    private val KEEP_ALIVE_TIME = 50L;


    override fun execute(abstractInteractor: AbstractInteractor) {
        mThreadPoolExecutor.execute {
            abstractInteractor.run()
        };
    }

    init {
        mThreadPoolExecutor = ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS, LinkedBlockingQueue())
    }
}