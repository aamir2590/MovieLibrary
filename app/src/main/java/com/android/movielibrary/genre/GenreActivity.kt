package com.android.movielibrary.genre

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.movielibrary.R
import dagger.android.AndroidInjection

class GenreActivity : AppCompatActivity(), GenreContract.View {

    var genrePresenter: GenreContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //sending this class instance to AndroidInjector so that all it's member variable get
        //injected. From previous version it is clear that now this Class will not know who is going to
        // inject its member variable
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)

    }

    override fun setPresenter(presenter: GenreContract.Presenter?) {
        genrePresenter = presenter
    }
}
