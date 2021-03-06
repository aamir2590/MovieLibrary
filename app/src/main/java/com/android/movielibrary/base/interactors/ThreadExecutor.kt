package com.android.movielibrary.base.interactors

import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by aamir on 12/02/18.
 */
@Singleton
class ThreadExecutor @Inject constructor() : Executor {

    override fun execute(command: Runnable?) {
        mThreadPoolExecutor.execute(command)
    }

    private val mThreadPoolExecutor: ThreadPoolExecutor
    private val CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private val MAX_POOL_SIZE = 2 * Runtime.getRuntime().availableProcessors() + 1
    private val KEEP_ALIVE_TIME = 50L;


    init {
        mThreadPoolExecutor = ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS, LinkedBlockingQueue())
    }
}