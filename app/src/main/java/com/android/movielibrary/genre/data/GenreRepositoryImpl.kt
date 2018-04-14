package com.android.movielibrary.genre.data

import com.android.movielibrary.base.di.customscope.ActivityScope
import com.android.movielibrary.genre.data.remote.GenreDataSource
import com.android.movielibrary.genre.domain.GenreRepository
import io.reactivex.Single
import javax.inject.Inject

/*
 * Created by aamir on 08/04/18.
 */
@ActivityScope
class GenreRepositoryImpl @Inject constructor(val genreDataSource: GenreDataSource) :
        GenreRepository {
    override fun getGenres(): Single<GenresList> = genreDataSource.getGenreList()

}
