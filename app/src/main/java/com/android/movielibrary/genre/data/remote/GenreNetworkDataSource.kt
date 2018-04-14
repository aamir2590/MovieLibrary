package com.android.movielibrary.genre.data.remote

import android.util.Log
import com.android.movielibrary.BASE_URL
import com.android.movielibrary.base.di.customscope.ActivityScope
import com.android.movielibrary.genre.data.Genre
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by aamir on 10/04/18.
 */
@ActivityScope
class GenreNetworkDataSource @Inject constructor(val genreAPI: GenreAPI) : GenreDataSource {

    override fun getGenreList(): Single<List<Genre>> = genreAPI.getGenre("2bc2c5d2c1b1775d2d6339cd983ef7e7", "en-US")
}