package com.android.movielibrary.genre.data.remote

import com.android.movielibrary.genre.data.GenresList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/*
 * Created by aamir on 08/04/18.
 */

//Only contain Network API for getting Genre from www.themoviedb.org
interface GenreService {
    @GET("genre/movie/list")
    fun getGenre(@Query("api_key") key: String,
                 @Query("language") language: String): Single<GenresList>

}