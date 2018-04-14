package com.android.movielibrary.genre.data.remote

import com.android.movielibrary.base.di.customscope.ActivityScope
import com.android.movielibrary.genre.data.Genre
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by aamir on 10/04/18.
 */
@ActivityScope
class GenreNetworkDataSource @Inject constructor(val genreService: GenreService) : GenreDataSource {

    override fun getGenreList(): Single<List<Genre>> = genreService.getGenre("2bc2c5d2c1b1775d2d6339cd983ef7e7", "en-US")
}