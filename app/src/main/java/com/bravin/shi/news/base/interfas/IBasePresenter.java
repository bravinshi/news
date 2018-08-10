package com.bravin.shi.news.base.interfas;

/**
 * created by bravin on 2018/6/7.
 */
public interface IBasePresenter {
    IBaseView getView();

    void init();

    void onFinish();

    void onResume();
}
