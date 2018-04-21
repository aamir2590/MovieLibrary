package com.android.movielibrary.genre.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.movielibrary.R
import com.android.movielibrary.genre.data.Genre
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_genre.*
import javax.inject.Inject

class GenreActivity : AppCompatActivity(), GenreContract.View {

    @Inject
    lateinit var genrePresenter: GenreContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        //sending this class instance to AndroidInjector so that all it's member variable get
        //injected. From previous version it is clear that now this Class will not know who is going to
        // inject its member variable
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)
        button.setOnClickListener {
            genrePresenter.getMovieGenre()
        }

    }

    override fun setPresenter(presenter: GenreContract.Presenter) {
        genrePresenter = presenter
    }

    override fun hideProgress() {
    }

    override fun showGenreList(genreList: List<Genre>?) {
    }

    override fun showProgress() {
    }

    override fun showErrorMsgToUser(errorMsg: String?) {
    }
}
