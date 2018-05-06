package com.android.movielibrary.genre.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.movielibrary.R
import com.android.movielibrary.genre.data.Genre
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_genre.*
import javax.inject.Inject

/**
 * Created by aamir on 06/05/18.
 */
class GenreRecyclerViewAdapter @Inject constructor(val context: Context) : RecyclerView.Adapter<GenreRecyclerViewAdapter.GenreItemViewHolder>() {

    private val genreList = mutableListOf<Genre>()

    //region Overriden Function
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GenreItemViewHolder {
        val genreItemView = LayoutInflater.from(context).inflate(R.layout.item_genre, parent, false)
        return GenreItemViewHolder(genreItemView)
    }

    override fun onBindViewHolder(holder: GenreItemViewHolder?, position: Int) {
        holder?.bind(genreList.get(position))
    }

    override fun getItemCount(): Int = genreList.size
    //endregion

    //region Member function
    fun showGenres(genresList: List<Genre>) {
        genresList.let {
            genreList.addAll(it)
        }
    }
    //endregion

    //region ViewHolder Inner class
    class GenreItemViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(movieGenre: Genre) {
            textView_genreRecyclerViewAdapter.text = movieGenre.name
        }
    }
    //endregion

}