package com.android.movielibrary.genre.data.remote

import com.android.movielibrary.genre.data.GenresList
import io.reactivex.Single

/**
 * Created by aamir on 10/04/18.
 */
interface GenreDataSource {
    fun getGenreList(): Single<GenresList>
}