package com.android.movielibrary.base.di

import com.android.movielibrary.base.interactors.MainThreadScheduler
import com.android.movielibrary.base.interactors.MainThreadSchedulerImpl
import com.android.movielibrary.base.interactors.ThreadExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

/*
 * Created by aamir on 01/04/18.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideHandler(): MainThreadScheduler = MainThreadSchedulerImpl()

    @Provides
    @Singleton
    fun provideThreadPoolExecutor(): Executor = ThreadExecutor()

}