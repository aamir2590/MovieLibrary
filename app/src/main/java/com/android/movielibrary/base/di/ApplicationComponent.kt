package com.android.movielibrary.base.di

import com.android.movielibrary.MovieLibraryApp
import com.android.movielibrary.base.interactors.Executor
import com.android.movielibrary.base.interactors.MainThread
import dagger.Component
import dagger.android.AndroidInjectionModule
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

    fun getHandler(): MainThread

    fun getThreadPoolExecutor(): Executor

}