package com.android.movielibrary.base.ui;

/**
 * Created by aamir on 30/03/18.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
