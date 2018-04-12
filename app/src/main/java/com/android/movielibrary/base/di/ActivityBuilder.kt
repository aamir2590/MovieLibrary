package com.android.movielibrary.base.di

import com.android.movielibrary.base.di.customscope.ActivityScope
import com.android.movielibrary.genre.ui.GenreActivity
import com.android.movielibrary.genre.di.GenreActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
 * Created by aamir on 01/04/18.
 */

/**
 * Contains all the android component {@link @SubComponent}, this helps dagger to know about
 * all the android components at compile time.
 */
@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(GenreActivityModule::class))
    abstract fun bindGenreActivity(): GenreActivity

}
