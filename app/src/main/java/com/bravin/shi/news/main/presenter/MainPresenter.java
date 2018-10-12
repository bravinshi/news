package com.bravin.shi.news.main.presenter;

import com.bravin.shi.news.base.interfas.IBaseView;
import com.bravin.shi.news.base.interfas.impl.BasePresenter;
import com.bravin.shi.news.main.ui.MainActivity;

/**
 * created by bravin on 2018/8/30.
 */
public class MainPresenter extends BasePresenter {
    private MainActivity view;

    public MainPresenter(MainActivity view) {
        this.view = view;
    }

    @Override
    public IBaseView getView() {
        return view;
    }

    @Override
    public void init() {

    }

    @Override
    public void onFinish() {

    }
}
