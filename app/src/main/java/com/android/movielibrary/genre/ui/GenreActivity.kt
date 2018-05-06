package com.android.movielibrary.genre.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.android.movielibrary.R
import com.android.movielibrary.genre.data.Genre
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_genre.*
import javax.inject.Inject

class GenreActivity : AppCompatActivity(), GenreContract.View {

    @Inject
    lateinit var genrePresenter: GenreContract.Presenter
    @Inject
    lateinit var genreRecyclerViewAdapter: GenreRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        //sending this class instance to AndroidInjector so that all it's member variable get
        //injected. From previous version it is clear that now this Class will not know who is going to
        // inject its member variable
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)
        initialiseGenreRecyclerView();
    }

    //region LifeCycle functions
    override fun onStart() {
        super.onStart()
        genrePresenter.getMovieGenre()
    }

    override fun onDestroy() {
        super.onDestroy()
        genrePresenter.onPresenterDestroy()
    }
    //endregion

    //region GenreContract.View Overriden funcitons
    override fun setPresenter(presenter: GenreContract.Presenter) {
        genrePresenter = presenter
    }

    override fun hideProgress() {
        progressBar_genreActivity.visibility = GONE
    }

    override fun showGenreList(genreList: List<Genre>) {
        genreRecyclerViewAdapter.run {
            showGenres(genreList)
            notifyDataSetChanged()
        }
    }

    override fun showProgress() {
        progressBar_genreActivity.visibility = VISIBLE
    }

    override fun showErrorMsgToUser(errorMsg: String?) {
    }
    //endregion

    //region Member functions
    private fun initialiseGenreRecyclerView() {

        recyclerView_genreActivity.also {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = genreRecyclerViewAdapter
        }

    }
    //endregion
}
