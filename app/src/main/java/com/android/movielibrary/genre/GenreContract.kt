package com.android.movielibrary.genre

import com.android.movielibrary.base.ui.BasePresenter
import com.android.movielibrary.base.ui.BaseView

/*
 * Created by aamir on 30/03/18.
 */
class GenreContract {
    interface Presenter : BasePresenter<GenreActivity>
    interface View : BaseView<Presenter>
}