package com.android.movielibrary.genre.domain

import com.android.movielibrary.genre.data.Genre
import io.reactivex.Single
import org.json.JSONObject

/*
 * Created by aamir on 08/04/18.
 */
interface GenreRepository {
    fun getGenres(): Single<List<Genre>>
}