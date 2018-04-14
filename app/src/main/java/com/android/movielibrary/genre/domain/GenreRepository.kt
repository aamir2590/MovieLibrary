package com.android.movielibrary.genre.domain

import com.android.movielibrary.genre.data.Genre
import io.reactivex.Single

/*
 * Created by aamir on 08/04/18.
 */
interface GenreRepository {
    fun getGenres(): Single<List<Genre>>
}