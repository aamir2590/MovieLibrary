package com.android.movielibrary.base.ui;

/**
 * Created by aamir on 30/03/18.
 */

public interface BasePresenter<T extends BaseView> {
    void setView(T view);
}
