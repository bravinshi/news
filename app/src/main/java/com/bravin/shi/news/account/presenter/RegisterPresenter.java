package com.bravin.shi.news.account.presenter;

import com.bravin.shi.news.account.ui.RegisterActivity;
import com.bravin.shi.news.base.BasePresenter;
import com.bravin.shi.news.base.interfas.IBaseView;

/**
 * created by bravin on 2018/8/17.
 */
public class RegisterPresenter extends BasePresenter {
    private RegisterActivity view;

    public RegisterPresenter(RegisterActivity view) {
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
