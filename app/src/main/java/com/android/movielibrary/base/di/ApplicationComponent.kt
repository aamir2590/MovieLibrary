package com.android.movielibrary.base.di

import com.android.movielibrary.MovieLibraryApp
import com.android.movielibrary.base.interactors.MainThreadScheduler
import dagger.Component
import dagger.android.AndroidInjectionModule
import java.util.concurrent.Executor
import javax.inject.Singleton

/*
 * Created by aamir on 01/04/18.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class))
interface ApplicationComponent {

    fun inject(app: MovieLibraryApp)

    fun getMainThreadScheduler(): MainThreadScheduler

    fun getThreadPoolExecutor(): Executor

}