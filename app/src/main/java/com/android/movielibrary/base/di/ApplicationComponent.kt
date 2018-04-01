package com.android.movielibrary.base.di

import android.app.Application
import com.android.movielibrary.MovieLibraryApp
import dagger.BindsInstance
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

    fun inject(app: MovieLibraryApp);

}