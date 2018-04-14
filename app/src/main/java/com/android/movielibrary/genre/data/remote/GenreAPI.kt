package com.android.movielibrary.genre.data.remote

import com.android.movielibrary.genre.data.Genre
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/*
 * Created by aamir on 08/04/18.
 */

//Only contain Network API for getting Genre from www.themoviedb.org
interface GenreAPI {
    @GET("/genre/movie/list")
    fun getGenre(@Query("key") key: String,
                 @Query("language") language: String): Single<List<Genre>>

}