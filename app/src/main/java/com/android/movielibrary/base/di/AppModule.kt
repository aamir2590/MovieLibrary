package com.android.movielibrary.base.di

import com.android.movielibrary.base.interactors.Executor
import com.android.movielibrary.base.interactors.MainThread
import com.android.movielibrary.base.interactors.MainThreadImpl
import com.android.movielibrary.base.interactors.ThreadExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
 * Created by aamir on 01/04/18.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideHandler(): MainThread = MainThreadImpl()

    @Provides
    @Singleton
    fun provideThreadPoolExecutor(): Executor = ThreadExecutor()

}