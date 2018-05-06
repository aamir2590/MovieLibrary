package com.android.movielibrary.base.di

import android.app.Application
import com.android.movielibrary.MovieLibraryApp
import com.android.movielibrary.base.interactors.MainThreadScheduler
import dagger.BindsInstance
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

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

}