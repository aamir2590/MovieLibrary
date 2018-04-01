package com.android.movielibrary.base.di

import com.android.movielibrary.genre.GenreActivity
import com.android.movielibrary.genre.GenreActivityModule
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

    @ContributesAndroidInjector(modules = arrayOf(GenreActivityModule::class))
    abstract fun bindGenreActivity(): GenreActivity

}
