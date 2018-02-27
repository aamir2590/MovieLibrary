package com.android.movielibrary.base.interactors

/**
 * Created by aamir on 12/02/18.
 */

/**
 * This abstract class define the common implementation for the child interactor. The Concrete class
 * that extends this must implements the run() method.
 *
 * @param threadExecutor singleton instance of Executor.
 * @param mainThread singleton instance of MainThread.
 * */
abstract class AbstractInteractor(threadExecutor: Executor,
                                  mainThread: MainThread) : Interactor {

    private val mThreadExecutor = threadExecutor
    private val mMainThreadExecutor = mainThread


    /*
    * Every Child interactor must implement their business logic in run(). And a Class must not
    * directly call this method instead it should call execute().
    **/
    abstract fun run();

    override fun execute() {
        mThreadExecutor.execute(this)
    }
}
