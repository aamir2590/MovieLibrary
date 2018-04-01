package com.android.movielibrary.genre

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.movielibrary.R

class GenreActivity : AppCompatActivity(), GenreContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)
    }
}
