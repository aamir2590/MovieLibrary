package com.android.movielibrary.genre.data.remote

import android.util.Log
import com.android.movielibrary.base.di.customscope.ActivityScope
import com.android.movielibrary.genre.data.Genre

/**
 * Created by aamir on 10/04/18.
 */
@ActivityScope
class GenreNetworkDataSource : GenreDataSource {

    override fun getGenreList(): List<Genre> {
        Log.d("Hello", " GetGenre XXXX")
        return mutableListOf()
    }
}