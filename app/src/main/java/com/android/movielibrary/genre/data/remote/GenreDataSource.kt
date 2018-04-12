package com.android.movielibrary.genre.data.remote

import com.android.movielibrary.genre.data.Genre

/**
 * Created by aamir on 10/04/18.
 */
interface GenreDataSource {
    fun getGenreList(): List<Genre>
}