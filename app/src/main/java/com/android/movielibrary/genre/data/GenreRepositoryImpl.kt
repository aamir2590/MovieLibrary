package com.android.movielibrary.genre.data

import com.android.movielibrary.base.di.customscope.ActivityScope
import com.android.movielibrary.genre.data.remote.GenreDataSource
import com.android.movielibrary.genre.domain.GenreRepository
import javax.inject.Inject

/*
 * Created by aamir on 08/04/18.
 */
@ActivityScope
class GenreRepositoryImpl @Inject constructor(val genreDataSource: GenreDataSource) :
        GenreRepository {
    override fun getGenres(): List<Genre> = genreDataSource.getGenreList();

}
